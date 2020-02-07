package SomePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeaderExtractor {
	public static void main(String agrs[]) {

		String paramterList = "<parameter name=\"%s\" class=\"java.lang.String\"/>";
		String fieldList = "<field name=\"%s\" class=\"java.lang.String\">\r\n"
				+ "		<fieldDescription><![CDATA[%s]]></fieldDescription>\r\n" + "	</field>";

//		String columnHeaderTextField = "<textField isStretchWithOverflow=\"true\">\r\n"
//				+ "				<reportElement style=\"columnHeaderStyle\" positionType=\"Float\" mode=\"Opaque\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"20\" isPrintWhenDetailOverflows=\"true\" backcolor=\"#CCCCCC\" />\r\n"
//				+ "				<box>\r\n" + "					<topPen lineWidth=\"0.5\"/>\r\n"
//				+ "					<leftPen lineWidth=\"0.5\"/>\r\n"
//				+ "					<bottomPen lineWidth=\"0.5\"/>\r\n"
//				+ "					<rightPen lineWidth=\"0.5\"/>\r\n" + "				</box>\r\n"
//				+ "				<textElement textAlignment=\"Left\" verticalAlignment=\"Middle\">\r\n"
//				+ "					<paragraph leftIndent=\"2\"/>\r\n" + "				</textElement>\r\n"
//				+ "				<textFieldExpression><![CDATA[$P{global.data.key}.get(\"%s\")]]></textFieldExpression>\r\n"
//				+ "			</textField>";
//
//		String detailTextField = "<textField isStretchWithOverflow=\"true\" isBlankWhenNull=\"true\">\r\n"
//				+ "				<reportElement style=\"detailStyle\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"20\" isPrintWhenDetailOverflows=\"true\" />\r\n"
//				+ "				<textElement textAlignment=\"Left\" verticalAlignment=\"Middle\">\r\n"
//				+ "					<paragraph rightIndent=\"2\"/>\r\n" + "				</textElement>\r\n"
//				+ "				<textFieldExpression><![CDATA[$F{%s}]]></textFieldExpression>\r\n"
//				+ "			</textField>";
		
		
		String columnHeaderTextField="<textField isStretchWithOverflow=\"true\">\r\n" + 
				"				<reportElement style=\"columnHeaderStyle\" positionType=\"Float\" mode=\"Opaque\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"20\" isPrintWhenDetailOverflows=\"true\" backcolor=\"#CCCCCC\" />\r\n" + 
				"				<box>\r\n" + 
				"					<pen lineWidth=\"0.5\" lineColor=\"#999999\"/>\r\n" + 
				"					<topPen lineWidth=\"0.5\" lineColor=\"#999999\"/>\r\n" + 
				"					<leftPen lineWidth=\"0.5\" lineColor=\"#999999\"/>\r\n" + 
				"					<bottomPen lineWidth=\"0.5\" lineColor=\"#999999\"/>\r\n" + 
				"					<rightPen lineWidth=\"0.5\" lineColor=\"#999999\"/>\r\n" + 
				"				</box>\r\n" + 
				"				<textElement textAlignment=\"Left\" verticalAlignment=\"Middle\">\r\n" + 
				"					<paragraph leftIndent=\"2\"/>\r\n" + 
				"				</textElement>\r\n" + 
				"				<textFieldExpression><![CDATA[$P{global.data.key}.get(\"%s\")]]></textFieldExpression>\r\n" + 
				"			</textField>";
		
		String detailTextField = "<textField isStretchWithOverflow=\"true\" isBlankWhenNull=\"true\">\r\n" + 
				"				<reportElement x=\"%d\" y=\"%d\" width=\"%d\" height=\"20\" >\r\n" + 
				"					<property name=\"com.jaspersoft.studio.unit.y\" value=\"px\"/>\r\n" + 
				"				</reportElement>\r\n" + 
				"				<box>\r\n" + 
				"					<pen lineWidth=\"0.5\" lineColor=\"#999999\"/>\r\n" + 
				"					<topPen lineWidth=\"0.5\" lineStyle=\"Solid\" lineColor=\"#999999\"/>\r\n" + 
				"					<leftPen lineWidth=\"0.5\" lineStyle=\"Solid\" lineColor=\"#999999\"/>\r\n" + 
				"					<bottomPen lineWidth=\"0.5\" lineStyle=\"Solid\" lineColor=\"#999999\"/>\r\n" + 
				"					<rightPen lineWidth=\"0.5\" lineStyle=\"Solid\" lineColor=\"#999999\"/>\r\n" + 
				"				</box>\r\n" + 
				"				<textElement textAlignment=\"Left\" verticalAlignment=\"Middle\"/>\r\n" + 
				"				<textFieldExpression><![CDATA[$F{%s}]]></textFieldExpression>\r\n" + 
				"			</textField>";
		int pageBorder = 9999999;
		int width = 100, heigth = 20;

		Map<String, String> subStringMap = new HashMap<String, String>();
		subStringMap.put("begin", ".get(\"");
		subStringMap.put("end", "\"))%>");
		List<String> label = extractValue(new File("header.txt"), subStringMap);
//		System.out.println(label);
		subStringMap.clear();
		subStringMap.put("begin", "formatString(obj.get");
		subStringMap.put("end", "())");
		List<String> body = extractValue(new File("body.txt"), subStringMap);
//		System.out.println(body);

		getParameter(paramterList, body);
		getField(fieldList, body);
		getColumnDetails(columnHeaderTextField, pageBorder, width, heigth, label);
		getColumnDetails(detailTextField, pageBorder, width, heigth, body);
	}

	private static void getColumnDetails(String columnHeaderTextField, int pageBorder, int width, int heigth,
			List<String> label) {
		System.out.println(label);
		int x = 0, y = 0;
		for (String element : label) {
			System.out.println(String.format(columnHeaderTextField, x, y, width, element));
			x += width;
			if (x + width > pageBorder) {
				x = 0;
				y += heigth;
			}
		}
	}

	private static void getField(String fieldList, List<String> body) {
		for (String element : body) {
			System.out.println(String.format(fieldList, element, element));
		}
	}

	private static void getParameter(String paramterList, List<String> body) {
		for (String element : body) {
			System.out.println(String.format(paramterList, element));
		}
	}

	private static List extractValue(File fp, Map<String, String> subStringMap) {
		List<String> value = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(fp);
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				int start_pos = -1, end_pos = -1;
				String start_Tag = subStringMap.get("begin");
				String end_tag = subStringMap.get("end");
				if ((start_pos = nextLine.indexOf(start_Tag)) != -1) {
					start_pos += start_Tag.length();
					end_pos = nextLine.lastIndexOf(end_tag);
				}
				if (start_pos > 0 && end_pos > 0) {
					String string = nextLine.substring(start_pos, end_pos);
					string = Character.toLowerCase(string.charAt(0)) + string.substring(1);
					value.add(string);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value.stream().distinct().collect(Collectors.toList());
	}

}
