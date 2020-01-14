package com.nri.AutoReleaseScheduler.Parameters;

import java.io.IOException;

public class Parameters {

	private String ready;
	private String date;
	private String immediate;
	private String releasePom;
	private String devPom;
	private String fixVersion;
	private String consoliScript;
	private String userId;
	private String password;
	private String email;
	
	public static Parameters getInstance() throws IOException{
		Parameters params=new Parameters();
		FetchParams.fetchParameters(params);
		return params;
	}

	public String getReady() {
		return ready;
	}

	@InfoParameter(key = "release.ready")
	public void setReady(String ready) {
		this.ready = ready;
	}

	public String getDate() {
		return date;
	}

	@InfoParameter(key = "release.date")
	public void setDate(String date) {
		this.date = date;
	}

	public String getImmediate() {
		return immediate;
	}

	@InfoParameter(key = "release.immediate")
	public void setImmediate(String immediate) {
		this.immediate = immediate;
	}

	public String getReleasePom() {
		return releasePom;
	}

	@InfoParameter(key = "release.param.release.pom")
	public void setReleasePom(String releasePom) {
		this.releasePom = releasePom;
	}

	public String getDevPom() {
		return devPom;
	}

	@InfoParameter(key = "release.param.dev.pom")
	public void setDevPom(String devPom) {
		this.devPom = devPom;
	}

	public String getFixVersion() {
		return fixVersion;
	}

	@InfoParameter(key = "release.param.fix.version")
	public void setFixVersion(String fixVersion) {
		this.fixVersion = fixVersion;
	}

	public String getConsoliScript() {
		return consoliScript;
	}

	@InfoParameter(key = "release.param.consolidate.script")
	public void setConsoliScript(String consoliScript) {
		this.consoliScript = consoliScript;
	}

	public String getUserId() {
		return userId;
	}

	@InfoParameter(key = "release.param.userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	@InfoParameter(key = "release.param.password")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	@InfoParameter(key = "release.param.email")
	public void setEmail(String email) {
		this.email = email;
	}

}
