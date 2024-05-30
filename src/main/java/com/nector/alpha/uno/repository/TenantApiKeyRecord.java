package com.nector.alpha.uno.repository;

public class TenantApiKeyRecord {

	Integer id;
	String name;
	String address;
	String apiKey;

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param apiKey
	 */
	public TenantApiKeyRecord(Integer id, String name, String address, String apiKey) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.apiKey = apiKey;
	}

	/**
	 * 
	 */
	public TenantApiKeyRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String toString() {
		return "TenantApiKeyRecord [id=" + id + ", name=" + name + ", address=" + address + ", apiKey=" + apiKey + "]";
	}

}
