package Streams.models;

public class Notes {
    
    private Integer id;
    private String name;
    public Notes(Integer id, String name, long val) {
        this.id = id;
        this.name = name;
        this.val = val;
    }
    private long val;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getVal() {
        return val;
    }
    public void setVal(long val) {
        this.val = val;
    }

    
}
