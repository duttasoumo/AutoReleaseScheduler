package com.nri.AutoReleaseScheduler.AutoReleaseSchedulerService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nri.AutoReleaseScheduler.Constants;
import com.nri.AutoReleaseScheduler.Parameters.Parameters;
import com.nri.AutoReleaseScheduler.Parameters.ResetParams;
@EnableScheduling
@Component
public class ServiceScheduler {

	Logger log = Logger.getLogger(ServiceScheduler.class);
	private Parameters params;
	@Scheduled(fixedDelay = 15000)
	public void run() throws Exception {
		try {
			params = Parameters.getInstance();
		} catch (IOException e) {
			log.error("INFO FILE NOT FOUND", e);
			throw e;
		}
		if (StringUtils.equalsIgnoreCase(params.getReady(), Constants.YES)) {
			try {
				readyForRelease();
			} catch (IOException | InterruptedException e) {
				log.error("Random Things Happended", e);
				throw e;
			}
		} else {
			// Don't Release
		}
	}

	/**
	 * @throws Exception
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ConfigurationException
	 * 
	 */
	private void readyForRelease() throws Exception {
		try {
			if (StringUtils.equalsIgnoreCase(params.getImmediate(), Constants.YES)) {
				doRelease();
				return;
			} else {
				Date date = getSystemDate();
				Date date1 = new SimpleDateFormat(Constants.DATE_FORMAT).parse(params.getDate());
				String time = new SimpleDateFormat(Constants.TIME_FORMAT).format(date);
				if (DateUtils.isSameDay(date, date1) && compareTime(time, Constants.RELEASE_TIME) >= 0) {
					doRelease();
					return;
				}
			}
		} catch (ParseException | ConfigurationException | IOException | InterruptedException e) {
			log.error("Wrong Date Specified: ", e);
			throw e;
		}
	}

	private long compareTime(String time, String releaseTime) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.TIME_FORMAT);
		Date sysTime = simpleDateFormat.parse(time);
		Date relTime = simpleDateFormat.parse(releaseTime);
		return sysTime.getTime() - relTime.getTime();
	}

	private void doRelease() throws IOException, InterruptedException, ConfigurationException {
		log.info("Release Process Started");
		log.info("IGV Release Started");
		executeReleaseScript(Constants.IGV_RELEASE_SCRIPT);
		log.info("IGV Release Completed");
		log.info("EIG Release Started");
		executeReleaseScript(Constants.EIG_RELEASE_SCRIPT);
		log.info("EIG Release Completed");
		log.info("Release Process Completed");
		updatePropertiesFile();
	}

	private void executeReleaseScript(String releaseScript)
			throws IOException, InterruptedException, ConfigurationException {
		List<String> commandList = commandList(releaseScript);
		Runtime rtime = Runtime.getRuntime();
		Process child = rtime.exec("cmd");
		BufferedWriter outCommand = new BufferedWriter(new OutputStreamWriter(child.getOutputStream()));
		for (String command : commandList) {
			outCommand.write(command);
			outCommand.flush();
		}
		int wait = child.waitFor();
		log.debug("Exit code for " + releaseScript + " : " + wait);
	}

	private void updatePropertiesFile() throws ConfigurationException, IOException {
		ResetParams.reset();
	}

	private Date getSystemDate() {
		return new Date();
	}

	private List<String> commandList(String releaseScript) {
		List<String> cmd = new ArrayList<String>();
		cmd.add("cd " + Constants.RELEASE_DIR + "\n");
		cmd.add("./" + releaseScript + "\n");
		cmd.add(params.getDevPom() + "\n");
		cmd.add(params.getReleasePom() + "\n");
		cmd.add(params.getFixVersion() + "\n");
		cmd.add(params.getConsoliScript() + "\n");
		cmd.add(params.getUserId() + "\n");
		cmd.add(params.getPassword() + "\n");
		cmd.add(params.getEmail() + "\n");
		cmd.add("tail -8 scheduler.log\n");
		cmd.add("exit" + "\n");
		return cmd;
	}
}
