package com.adwait.model;

public class Country {
	private String country;
	private String unMemberStatus;
	private String sovereigntyDispute;
	private String moreInfo;

	public Country() {
		super();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUnMemberStatus() {
		return unMemberStatus;
	}

	public void setUnMemberStatus(String unMemberStatus) {
		this.unMemberStatus = unMemberStatus;
	}

	public String getSovereigntyDispute() {
		return sovereigntyDispute;
	}

	public void setSovereigntyDispute(String sovereigntyDispute) {
		this.sovereigntyDispute = sovereigntyDispute;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

}