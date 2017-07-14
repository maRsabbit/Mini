package phone;

public class Phone {

	private String index;
	private String name;
    private String hp;
    private String company;
    

    public Phone(String name, String hp, String company) {
    	this.name=name;
    	this.hp=hp;
    	this.company=company;
    }
    public Phone(String index, String name, String hp, String company) {
    	this.index = index;
    	this.name=name;
    	this.hp=hp;
    	this.company=company;
    }

    public Phone() {}
	//필요한 메소드 작
    public void setPhone3(String name, String hp, String company) {
    	this.name=name;
    	this.hp=hp;
    	this.company=company;
    }
    
    public void setPhone(String index, String name, String hp, String company) {
    	this.index = index;
    	this.name=name;
    	this.hp=hp;
    	this.company=company;
    }
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public String getHp() {
		return hp;
	}
	public void setNum(String index) {
    	this.index = index;
	}
	public void setName(String name) {
    	this.name=name;
    }
    public void setHp(String hp) {
    	this.hp=hp;
    }
    public void setcompany(String company) {
    	this.company=company;
    }
    public void showInfo(){
        System.out.println(index+". 이름 : "+name+"\t핸드폰 : "+hp+"\t직장 : "+company);
    }
    public void showInfo2(){
        System.out.println(". 이름 : "+name+"\t핸드폰 : "+hp+"\t직장 : "+company);
    }

}
