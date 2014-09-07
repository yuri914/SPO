package br.com.spo.model.enumerations;

public enum Telas {
    
    HOME("/pages/Home"), INDEX("/Index");
    
    private String url;

    private Telas(String url) {
        this.url = url;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

}
