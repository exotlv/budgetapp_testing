package lv.vsikhvart.cucumber.enums;


public enum CategorySelector {

    Income("15"),
    Outcome("6");

    private String categorySelectorId;

    CategorySelector(String categorySelectorId) {
        this.categorySelectorId = categorySelectorId;
    }

    @Override
    public String toString() {
      return categorySelectorId;
    }
}
