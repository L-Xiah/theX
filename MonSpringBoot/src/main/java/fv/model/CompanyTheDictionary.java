package fv.model;


import fv.support.BaseModel;

/**
 * 
 */
public class CompanyTheDictionary extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private Integer value;
    private Integer inddex;
    private Integer type;
    private String typedes;//类型描述
    private Integer typechild;//typechild
    private String description;
	private String member;//负责人工号
	private String memberName;//负责人name


	private String department;//权限管理
    
    private Integer theyear;//theyear
    private Integer isfreeze;//冻结点


	private String depart;//对应priviledge表的department
    private String upname;//上级name
    private String createdbyname;//上级name
    private String lastupdatebyname;//上级name


	private String last_update_by;//



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getInddex() {
		return inddex;
	}

	public void setInddex(Integer inddex) {
		this.inddex = inddex;
	}

	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getTypedes() {
		return typedes;
	}

	public void setTypedes(String comment) {
		this.typedes = comment;
	}

	public Integer getTypechild() {
		return typechild;
	}

	public void setTypechild(Integer typechild) {
		this.typechild = typechild;
	}

	public Integer getTheyear() {
		return theyear;
	}

	public void setTheyear(Integer theyear) {
		this.theyear = theyear;
	}
	
	public Integer getIsfreeze() {
		return isfreeze;
	}

	public void setIsfreeze(Integer isfreeze) {
		this.isfreeze = isfreeze;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getUpname() {
		return upname;
	}

	public void setUpname(String upname) {
		this.upname = upname;
	}

	public String getCreatedbyname() {
		return createdbyname;
	}

	public void setCreatedbyname(String createdbyname) {
		this.createdbyname = createdbyname;
	}

	public String getLastupdatebyname() {
		return lastupdatebyname;
	}

	public void setLastupdatebyname(String lastupdatebyname) {
		this.lastupdatebyname = lastupdatebyname;
	}

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getLast_update_by() {
		return last_update_by;
	}

	public void setLast_update_by(String last_update_by) {
		this.last_update_by = last_update_by;
	}
}