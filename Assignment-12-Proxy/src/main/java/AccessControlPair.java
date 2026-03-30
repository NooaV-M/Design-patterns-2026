public class AccessControlPair {
    public String username;
    public Integer docID;
    public AccessControlPair(String username, Integer docID){
        // assign constructor parameters to the fields so they are not left null
        this.username = username;
        this.docID = docID;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AccessControlPair that = (AccessControlPair) o;
        return username.equals(that.username) && docID.equals(that.docID);
    }
}
