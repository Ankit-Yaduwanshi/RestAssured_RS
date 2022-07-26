package pojo;

import java.util.List;

public class Courses {
	private List<WebAutomation> WebAutomation;
	private List<API> API;
	private List<Mobile> Mobile;
	
	public List<Mobile> getMobile() {
		return Mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		Mobile = mobile;
	}
	public List<API> getAPI() {
		return API;
	}
	public void setAPI(List<API> aPI) {
		API = aPI;
	}
	public List<pojo.WebAutomation> getWebAutomation() {
		return WebAutomation;
	}
	public void setWebAutomation(List<pojo.WebAutomation> webAutomation) {
		WebAutomation = webAutomation;
	}

	
}
