package model;

public class PromotoDB {
	
	private Integer id_offer;
	private String offerCLass;
	private String name;
	private String tipe;
	private String atr1;
	private String atr2;
	private String freeatr;
	private Integer percent;
	private Integer abs;
	private String description;
	
	public PromotoDB(Integer id_offer, String offerCLass, String name, String tipe, String atr1, String atr2,
			String freeatr, Integer percent, Integer abs, String description) {
		super();
		this.id_offer = id_offer;
		this.offerCLass = offerCLass;
		this.name = name;
		this.tipe = tipe;
		this.atr1 = atr1;
		this.atr2 = atr2;
		this.freeatr = freeatr;
		this.percent = percent;
		this.abs = abs;
		this.description = description;
	}

	public Integer getId_offer() {
		return id_offer;
	}

	public void setId_offer(Integer id_offer) {
		this.id_offer = id_offer;
	}

	public String getOfferCLass() {
		return offerCLass;
	}

	public void setOfferCLass(String offerCLass) {
		this.offerCLass = offerCLass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	public String getAtr1() {
		return atr1;
	}

	public void setAtr1(String atr1) {
		this.atr1 = atr1;
	}

	public String getAtr2() {
		return atr2;
	}

	public void setAtr2(String atr2) {
		this.atr2 = atr2;
	}

	public String getFreeatr() {
		return freeatr;
	}

	public void setFreeatr(String freeatr) {
		this.freeatr = freeatr;
	}

	public Integer getPercent() {
		return percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	public Integer getAbs() {
		return abs;
	}

	public void setAbs(Integer abs) {
		this.abs = abs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}