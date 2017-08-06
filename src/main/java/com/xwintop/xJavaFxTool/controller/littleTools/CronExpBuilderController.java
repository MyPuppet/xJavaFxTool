package com.xwintop.xJavaFxTool.controller.littleTools;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.CronExpression;

import com.xwintop.xJavaFxTool.utils.JavaFxViewUtil;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class CronExpBuilderController implements Initializable {
	@FXML
	private TabPane mainTabPane;
	@FXML
	private Tab tabSecond;
	@FXML
	private RadioButton radioButtonSecond1;
	@FXML
	private ToggleGroup toggleGroupSecond;
	@FXML
	private RadioButton radioButtonSecond2;
	@FXML
	private Spinner<Integer> secondStart_0;
	@FXML
	private Spinner<Integer> secondEnd_0;
	@FXML
	private RadioButton radioButtonSecond3;
	@FXML
	private Spinner<Integer> secondStart_1;
	@FXML
	private Spinner<Integer> secondEnd_1;
	@FXML
	private RadioButton radioButtonSecond4;
	@FXML
	private Tab tabMinute;
	@FXML
	private RadioButton radioButtonMinute1;
	@FXML
	private ToggleGroup toggleGroupMinute;
	@FXML
	private RadioButton radioButtonMinute2;
	@FXML
	private Spinner<Integer> minuteStart_0;
	@FXML
	private Spinner<Integer> minuteEnd_0;
	@FXML
	private RadioButton radioButtonMinute3;
	@FXML
	private Spinner<Integer> minuteStart_1;
	@FXML
	private Spinner<Integer> minuteEnd_1;
	@FXML
	private RadioButton radioButtonMinute4;
	@FXML
	private Tab tabHour;
	@FXML
	private RadioButton radioButtonHour1;
	@FXML
	private ToggleGroup toggleGroupHour;
	@FXML
	private RadioButton radioButtonHour2;
	@FXML
	private Spinner<Integer> hourStart_0;
	@FXML
	private Spinner<Integer> hourEnd_0;
	@FXML
	private RadioButton radioButtonHour3;
	@FXML
	private Spinner<Integer> hourStart_1;
	@FXML
	private Spinner<Integer> hourEnd_1;
	@FXML
	private RadioButton radioButtonHour4;
	@FXML
	private Tab tabDay;
	@FXML
	private RadioButton radioButtonDay1;
	@FXML
	private ToggleGroup toggleGroupDay;
	@FXML
	private RadioButton radioButtonDay3;
	@FXML
	private Spinner<Integer> dayStart_0;
	@FXML
	private Spinner<Integer> dayEnd_0;
	@FXML
	private RadioButton radioButtonDay4;
	@FXML
	private Spinner<Integer> dayStart_1;
	@FXML
	private Spinner<Integer> dayEnd_1;
	@FXML
	private RadioButton radioButtonDay7;
	@FXML
	private RadioButton radioButtonDay2;
	@FXML
	private RadioButton radioButtonDay5;
	@FXML
	private Spinner<Integer> dayStart_2;
	@FXML
	private RadioButton radioButtonDay6;
	@FXML
	private Tab tabMonth;
	@FXML
	private RadioButton radioButtonMonth1;
	@FXML
	private ToggleGroup toggleGroupMonth;
	@FXML
	private RadioButton radioButtonMonth3;
	@FXML
	private Spinner<Integer> monthStart_0;
	@FXML
	private Spinner<Integer> monthEnd_0;
	@FXML
	private RadioButton radioButtonMonth4;
	@FXML
	private Spinner<Integer> monthStart_1;
	@FXML
	private Spinner<Integer> monthEnd_1;
	@FXML
	private RadioButton radioButtonMonth6;
	@FXML
	private RadioButton radioButtonMonth2;
	@FXML
	private RadioButton radioButtonMonth5;
	@FXML
	private Tab tabWeek;
	@FXML
	private RadioButton radioButtonWeek1;
	@FXML
	private ToggleGroup toggleGroupWeek;
	@FXML
	private RadioButton radioButtonWeek3;
	@FXML
	private Spinner<Integer> weekStart_0;
	@FXML
	private Spinner<Integer> weekEnd_0;
	@FXML
	private RadioButton radioButtonWeek4;
	@FXML
	private Spinner<Integer> weekStart_1;
	@FXML
	private Spinner<Integer> weekEnd_1;
	@FXML
	private RadioButton radioButtonWeek6;
	@FXML
	private RadioButton radioButtonWeek2;
	@FXML
	private Spinner<Integer> weekStart_2;
	@FXML
	private RadioButton radioButtonWeek5;
	@FXML
	private Tab tabYear;
	@FXML
	private RadioButton radioButtonYear1;
	@FXML
	private ToggleGroup toggleGroupYear;
	@FXML
	private RadioButton radioButtonYear3;
	@FXML
	private Spinner<Integer> yearStart_0;
	@FXML
	private Spinner<Integer> yearEnd_0;
	@FXML
	private RadioButton radioButtonYear2;
	@FXML
	private TextField jTF_Cron_Second;
	@FXML
	private TextField jTF_Cron_Minute;
	@FXML
	private TextField jTF_Cron_Hour;
	@FXML
	private TextField jTF_Cron_Day;
	@FXML
	private TextField jTF_Cron_Month;
	@FXML
	private TextField jTF_Cron_Week;
	@FXML
	private TextField jTF_Cron_Year;
	@FXML
	private TextField jTF_Cron_Exp;
	@FXML
	private Button button_Parse;
	@FXML
	private TextField jTF_Schedule_Start;
	@FXML
	private Button copyExpButton;
	@FXML
	private TextArea jTA_Schedule_Next;

	private CheckBox[] secondCheckBox = new CheckBox[60];
	private CheckBox[] minuteCheckBox = new CheckBox[60];
	private CheckBox[] hourCheckBox = new CheckBox[24];
	private CheckBox[] dayCheckBox = new CheckBox[31];
	private CheckBox[] monthCheckBox = new CheckBox[12];
	private CheckBox[] weekCheckBox = new CheckBox[7];

	private Tab[] tabs;
	private TextField[] cronTextFields;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initView();
		initEvent();
	}

	private void initView() {
		tabs = new Tab[] { tabSecond, tabMinute, tabHour, tabDay, tabMonth, tabWeek, tabYear };
		cronTextFields = new TextField[] { jTF_Cron_Second, jTF_Cron_Minute, jTF_Cron_Hour,
				jTF_Cron_Day, jTF_Cron_Month, jTF_Cron_Week, jTF_Cron_Year };
		Calendar calendar = Calendar.getInstance();
		JavaFxViewUtil.setSpinnerValueFactory(secondStart_0, 1, 58);
		JavaFxViewUtil.setSpinnerValueFactory(secondEnd_0, 2, 59);
		JavaFxViewUtil.setSpinnerValueFactory(secondStart_1, 0, 59);
		JavaFxViewUtil.setSpinnerValueFactory(secondEnd_1, 1, 59);
		JavaFxViewUtil.setSpinnerValueFactory(minuteStart_0, 1, 58, calendar.get(Calendar.MINUTE));
		JavaFxViewUtil.setSpinnerValueFactory(minuteEnd_0, 2, 59, calendar.get(Calendar.MINUTE) + 1);
		JavaFxViewUtil.setSpinnerValueFactory(minuteStart_1, 0, 59, calendar.get(Calendar.MINUTE));
		JavaFxViewUtil.setSpinnerValueFactory(minuteEnd_1, 1, 59);
		JavaFxViewUtil.setSpinnerValueFactory(hourStart_0, 0, 23, calendar.get(Calendar.HOUR));
		JavaFxViewUtil.setSpinnerValueFactory(hourEnd_0, 2, 23, calendar.get(Calendar.HOUR) + 1);
		JavaFxViewUtil.setSpinnerValueFactory(hourStart_1, 0, 23, calendar.get(Calendar.HOUR));
		JavaFxViewUtil.setSpinnerValueFactory(hourEnd_1, 1, 23);
		JavaFxViewUtil.setSpinnerValueFactory(dayStart_0, 1, 31, calendar.get(Calendar.DAY_OF_MONTH));
		JavaFxViewUtil.setSpinnerValueFactory(dayEnd_0, 2, 31, calendar.get(Calendar.DAY_OF_MONTH) + 1);
		JavaFxViewUtil.setSpinnerValueFactory(dayStart_1, 1, 31, calendar.get(Calendar.DAY_OF_MONTH));
		JavaFxViewUtil.setSpinnerValueFactory(dayEnd_1, 1, 31);
		JavaFxViewUtil.setSpinnerValueFactory(dayStart_2, 1, 31, calendar.get(Calendar.DAY_OF_MONTH));
		JavaFxViewUtil.setSpinnerValueFactory(monthStart_0, 1, 12, calendar.get(Calendar.MONTH) + 1);
		JavaFxViewUtil.setSpinnerValueFactory(monthEnd_0, 2, 12, calendar.get(Calendar.MONTH) + 1);
		JavaFxViewUtil.setSpinnerValueFactory(monthStart_1, 1, 12, calendar.get(Calendar.DAY_OF_MONTH));
		JavaFxViewUtil.setSpinnerValueFactory(monthEnd_1, 1, 12);
		JavaFxViewUtil.setSpinnerValueFactory(weekStart_0, 1, 7);
		JavaFxViewUtil.setSpinnerValueFactory(weekEnd_0, 2, 7);
		JavaFxViewUtil.setSpinnerValueFactory(weekStart_1, 1, 4);
		JavaFxViewUtil.setSpinnerValueFactory(weekEnd_1, 1, 7, calendar.get(Calendar.DAY_OF_WEEK));
		JavaFxViewUtil.setSpinnerValueFactory(weekStart_2, 1, 7);
		JavaFxViewUtil.setSpinnerValueFactory(yearStart_0, 2012, 3000, calendar.get(Calendar.YEAR));
		JavaFxViewUtil.setSpinnerValueFactory(yearEnd_0, 2013, 3000, calendar.get(Calendar.YEAR) + 1);
		for (int i = 0; i < 60; i++) {
			secondCheckBox[i] = new CheckBox(String.format("%02d", i));
			secondCheckBox[i].setLayoutX(32 + i % 10 * 60);
			secondCheckBox[i].setLayoutY(120 + i / 10 * 20);
			((AnchorPane) tabSecond.getContent()).getChildren().add(secondCheckBox[i]);
			minuteCheckBox[i] = new CheckBox(String.format("%02d", i));
			minuteCheckBox[i].setLayoutX(32 + i % 10 * 60);
			minuteCheckBox[i].setLayoutY(120 + i / 10 * 20);
			((AnchorPane) tabMinute.getContent()).getChildren().add(minuteCheckBox[i]);
			if (i < 24) {
				hourCheckBox[i] = new CheckBox(String.format("%02d", i));
				hourCheckBox[i].setLayoutX(32 + i % 10 * 60);
				hourCheckBox[i].setLayoutY(120 + i / 10 * 20);
				((AnchorPane) tabHour.getContent()).getChildren().add(hourCheckBox[i]);
			}
			if (i < 31) {
				dayCheckBox[i] = new CheckBox(String.format("%2d", i + 1));
				dayCheckBox[i].setLayoutX(32 + i % 12 * 60);
				dayCheckBox[i].setLayoutY(200 + i / 12 * 20);
				((AnchorPane) tabDay.getContent()).getChildren().add(dayCheckBox[i]);
			}
			if (i < 12) {
				monthCheckBox[i] = new CheckBox(String.format("%2d", i + 1));
				monthCheckBox[i].setLayoutX(32 + i % 12 * 50);
				monthCheckBox[i].setLayoutY(146);
				((AnchorPane) tabMonth.getContent()).getChildren().add(monthCheckBox[i]);
			}
			if (i < 7) {
				weekCheckBox[i] = new CheckBox(String.format("%2d", i + 1));
				weekCheckBox[i].setLayoutX(32 + i % 10 * 60);
				weekCheckBox[i].setLayoutY(180 + i / 10 * 20);
				((AnchorPane) tabWeek.getContent()).getChildren().add(weekCheckBox[i]);
			}
		}
	}

	private void initEvent() {
		for (int i = 0; i < cronTextFields.length; i++) {
			cronTextFields[i].textProperty().addListener(getChangeListener());
		}
		for(int i = 0; i < secondCheckBox.length; i++) {
			secondCheckBox[i].selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
//					StringUtils.join(cronTextFields, ",");
				}
			});
		}
	}

	private ChangeListener<String> getChangeListener() {
		return new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				TextField textField = (TextField) ((StringProperty) arg0).getBean();
//				System.out.println(textField.getId() + "   " + oldValue + "   " + newValue);
//				System.out.println("状态：当前字符数为：" + jTF_Cron_Second.getText());
				int currentIndex = mainTabPane.getSelectionModel().getSelectedIndex();
				// 当前选中项之前的如果为*，则都设置成0
				for (int i = currentIndex; i >= 1; i--) {
					if (cronTextFields[i].getText() != "*" && cronTextFields[i - 1].getText() == "*") {
						cronTextFields[i - 1].setText("0");
					}
				}
				// 当前选中项之后的如果不为*则都设置成*
				if (cronTextFields[currentIndex].getText() == "*") {
					for (int i = currentIndex + 1; i < cronTextFields.length; i++) {
						if (i == 5) {
							cronTextFields[i].setText("?");
						} else {
							cronTextFields[i].setText("*");
						}
					}
				}
				StringBuilder stringBuilder = new StringBuilder();
				for(int i = 0; i < cronTextFields.length; i++) {
					stringBuilder.append(cronTextFields[i].getText());
				}
				jTF_Cron_Exp.setText(stringBuilder.toString());
			}
		};
	}

	@FXML
	private void parseActionPerformed(ActionEvent event) throws Exception {
		String cronExpString = jTF_Cron_Exp.getText().trim();
		if (StringUtils.isEmpty(cronExpString)) {
			return;
		}
		String[] regs = cronExpString.split(" ");
		jTF_Cron_Second.setText(regs[0]);
		jTF_Cron_Minute.setText(regs[1]);
		jTF_Cron_Hour.setText(regs[2]);
		jTF_Cron_Day.setText(regs[3]);
		jTF_Cron_Month.setText(regs[4]);
		jTF_Cron_Week.setText(regs[5]);

		jTA_Schedule_Next.setText("");
		CronExpression exp = new CronExpression(cronExpString);
		java.util.Date dd = new java.util.Date();
		jTF_Schedule_Start.setText(DateFormatUtils.format(dd, "yyyy-MM-dd HH:mm:ss"));
		// for (int i = 1; i <= 8; i++) {
		// dd = exp.getNextValidTimeAfter(dd);
		// jTA_Schedule_Next.appendText(i + ": " + DateFormatUtils.format(dd,
		// "yyyy-MM-dd HH:mm:ss") + "\n");
		// dd = new java.util.Date(dd.getTime() + 1000);
		// }

		initObj(regs[0], "Second");
		initObj(regs[1], "Minute");
		initObj(regs[2], "Hour");
		initDay(regs[3]);
		initMonth(regs[4]);
		initWeek(regs[5]);

		if (regs.length > 6) {
			initYear(regs[6]);
		} else {
			initYear(null);
		}
	}

	@SuppressWarnings("unchecked")
	private void initObj(String strVal, String strid) throws Exception {
		ToggleGroup toggleGroup = (ToggleGroup) CronExpBuilderController.class.getDeclaredField("toggleGroup" + strid)
				.get(this);
		// var objRadio = $("input[name='" + strid + "'");
		if ("*".equals(strVal)) {
			toggleGroup.selectToggle(toggleGroup.getToggles().get(0));
		} else if (strVal.contains("-")) {
			String[] ary = strVal.split("-");
			toggleGroup.selectToggle(toggleGroup.getToggles().get(1));
			((Spinner<Integer>) CronExpBuilderController.class.getDeclaredField(strid.toLowerCase() + "Start_0")
					.get(this)).getEditor().setText(ary[0]);
			((Spinner<Integer>) CronExpBuilderController.class.getDeclaredField(strid.toLowerCase() + "End_0")
					.get(this)).getEditor().setText(ary[1]);
			// s.getValueFactory().setValue("");
		} else if (strVal.split("/").length > 1) {
			String[] ary = strVal.split("/");
			toggleGroup.selectToggle(toggleGroup.getToggles().get(2));
			((Spinner<Integer>) CronExpBuilderController.class.getDeclaredField(strid.toLowerCase() + "Start_1")
					.get(this)).getEditor().setText(ary[0]);
			((Spinner<Integer>) CronExpBuilderController.class.getDeclaredField(strid.toLowerCase() + "End_1")
					.get(this)).getEditor().setText(ary[1]);
		} else {
			toggleGroup.selectToggle(toggleGroup.getToggles().get(3));
			if (!"?".equals(strVal)) {
				String[] ary = strVal.split(",");
				CheckBox[] checkBox = (CheckBox[]) getClass().getDeclaredField(strid.toLowerCase() + "CheckBox")
						.get(this);
				for (int i = 0; i < ary.length; i++) {
					checkBox[Integer.parseInt(ary[i])].setSelected(true);
				}
			}
		}
	}

	private void initDay(String strVal) throws Exception {
		if ("*".equals(strVal)) {
			radioButtonDay1.setSelected(true);
		} else if ("?".equals(strVal)) {
			radioButtonDay2.setSelected(true);
		} else if (strVal.contains("-")) {
			String[] ary = strVal.split("-");
			radioButtonDay3.setSelected(true);
			dayStart_0.getEditor().setText(ary[0]);
			dayEnd_0.getEditor().setText(ary[1]);
		} else if (strVal.contains("/")) {
			String[] ary = strVal.split("/");
			radioButtonDay4.setSelected(true);
			dayStart_1.getEditor().setText(ary[0]);
			dayEnd_1.getEditor().setText(ary[1]);
		} else if (strVal.contains("W")) {
			String[] ary = strVal.split("W");
			radioButtonDay5.setSelected(true);
			dayStart_2.getEditor().setText(ary[0]);
		} else if ("L".equals(strVal)) {
			radioButtonDay6.setSelected(true);
		} else {
			radioButtonDay7.setSelected(true);
			String[] ary = strVal.split(",");
			for (int i = 0; i < ary.length; i++) {
				dayCheckBox[Integer.parseInt(ary[i])].setSelected(true);
			}
		}
	}

	private void initMonth(String strVal) throws Exception {
		if ("*".equals(strVal)) {
			radioButtonMonth1.setSelected(true);
		} else if ("?".equals(strVal)) {
			radioButtonMonth2.setSelected(true);
		} else if (strVal.contains("-")) {
			String[] ary = strVal.split("-");
			radioButtonMonth3.setSelected(true);
			monthStart_0.getEditor().setText(ary[0]);
			monthEnd_0.getEditor().setText(ary[1]);
		} else if (strVal.contains("/")) {
			String[] ary = strVal.split("/");
			radioButtonMonth4.setSelected(true);
			monthStart_1.getEditor().setText(ary[0]);
			monthEnd_1.getEditor().setText(ary[1]);
		} else {
			radioButtonMonth5.setSelected(true);
			String[] ary = strVal.split(",");
			for (int i = 0; i < ary.length; i++) {
				monthCheckBox[Integer.parseInt(ary[i])].setSelected(true);
			}
		}
	}

	private void initWeek(String strVal) throws Exception {
		if ("*".equals(strVal)) {
			radioButtonWeek1.setSelected(true);
		} else if ("?".equals(strVal)) {
			radioButtonWeek2.setSelected(true);
		} else if (strVal.contains("-")) {
			String[] ary = strVal.split("-");
			radioButtonWeek3.setSelected(true);
			weekStart_0.getEditor().setText(ary[0]);
			weekEnd_0.getEditor().setText(ary[1]);
		} else if (strVal.contains("/")) {
			String[] ary = strVal.split("/");
			radioButtonWeek4.setSelected(true);
			weekStart_1.getEditor().setText(ary[0]);
			weekEnd_1.getEditor().setText(ary[1]);
		} else if (strVal.contains("L")) {
			String[] ary = strVal.split("L");
			radioButtonWeek5.setSelected(true);
			weekStart_2.getEditor().setText(ary[0]);
		} else {
			radioButtonWeek6.setSelected(true);
			String[] ary = strVal.split(",");
			for (int i = 0; i < ary.length; i++) {
				weekCheckBox[Integer.parseInt(ary[i])].setSelected(true);
			}
		}
	}

	private void initYear(String strVal) throws Exception {
		jTF_Cron_Year.setText(strVal);
		if (StringUtils.isEmpty(strVal)) {
			radioButtonWeek1.setSelected(true);
		} else if ("*".equals(strVal)) {
			radioButtonYear2.setSelected(true);
		} else if (strVal.contains("-")) {
			radioButtonYear3.setSelected(true);
			String[] ary = strVal.split("-");
			yearStart_0.getEditor().setText(ary[0]);
			yearEnd_0.getEditor().setText(ary[1]);
		}
	}

	@FXML
	private void copyExpAction(ActionEvent event) throws Exception {
		// toggleGroupSecond.selectToggle(toggleGroupSecond.getToggles().get(Integer.valueOf(jTF_Cron_Exp.getText())));
		// jTF_Schedule_Start.setText(jTF_Cron_Exp.getText());
		// jTA_Schedule_Next.setText(jTF_Cron_Exp.getText());
	}
}