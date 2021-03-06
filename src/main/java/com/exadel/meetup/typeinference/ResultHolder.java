package com.exadel.meetup.typeinference;

class ResultHolder {
    private final String groupName;
    private final String name;
    private final int result;

    ResultHolder(String groupName, String name, int result) {
        this.groupName = groupName;
        this.name = name;
        this.result = result;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "groupName='" + groupName + '\'' +
                ", name='" + name + '\'' +
                ", result=" + result +
                '}';
    }
}
