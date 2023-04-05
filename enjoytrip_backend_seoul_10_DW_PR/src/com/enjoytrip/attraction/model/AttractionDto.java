package com.enjoytrip.attraction.model;

public class AttractionDto {

	private int contentId;
	private int contentTypeId;
	private String title;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String tel;
	private String firstImage;
	private String firstImage2;
	private int readcount;
	private int sidoCode;
	private int gugunCode;
	private double latitude;
	private double longitude;
	private String mlevel;
	
	
	public AttractionDto() {
		
	}
	
	public AttractionDto(int contentId, int contentTypeId, String title, double latitude, double longitude) {
		super();
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public AttractionDto(String str) {
		super();
		String[] aDetail=str.split(",");
		this.contentId = Integer.parseInt(aDetail[0]);
		this.contentTypeId = Integer.parseInt(aDetail[1]);
		this.title = aDetail[2];
		this.latitude = Double.parseDouble(aDetail[3]);
		this.longitude = Double.parseDouble(aDetail[4]);
	}
	
	public AttractionDto(int contentId, int contentTypeId, String title, String addr1, String addr2, String zipcode,
			String tel, String firstImage, String firstImage2, int readcount, int sidoCode, int gugunCode,
			double latitude, double longitude, String mlevel) {
		super();
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.title = title;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.tel = tel;
		this.firstImage = firstImage;
		this.firstImage2 = firstImage2;
		this.readcount = readcount;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mlevel = mlevel;
	}
	public int getcontentId() {
		return contentId;
	}
	public void setcontentId(int contentId) {
		this.contentId = contentId;
	}
	public int getcontentTypeId() {
		return contentTypeId;
	}
	public void setcontentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getfirstImage() {
		return firstImage;
	}
	public void setfirstImage(String firstImage) {
		this.firstImage = firstImage;
	}
	public String getfirstImage2() {
		return firstImage2;
	}
	public void setfirstImage2(String firstImage2) {
		this.firstImage2 = firstImage2;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getsidoCode() {
		return sidoCode;
	}
	public void setsidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public int getgugunCode() {
		return gugunCode;
	}
	public void setgugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public String getRouteElement() {
		StringBuilder sb= new StringBuilder();
		sb.append("(").append(contentId).append(",").append(contentTypeId).append(",").append(title).append(",").append(longitude).append(",").append(latitude).append(")");
		
		return sb.toString();
	}

	

}
