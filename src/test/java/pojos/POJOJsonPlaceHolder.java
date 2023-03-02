package pojos;

public class POJOJsonPlaceHolder {
    /*
    Request Body
                    {
                    "title":"Ahmet",
                    "body":"Merhaba",
                    "userId":10,
                    "id":70
                    }
     */

    // 1. Adim : Objemizin içerisindeki tüm Key değerlerini private variable olarak tanımlayalım

    private String title;
    private String body;
    private String userId;
    private int id;

    // 2. Adim : Prepare Getter and setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3. Adim : Tum parametleri içeren constructor olustur


    public POJOJsonPlaceHolder(String title, String body, String userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4. Adım : Parametresiz constructor olustur


    public POJOJsonPlaceHolder() {

    }

    // 5. Adım : ToString methodu olustur


    @Override
    public String toString() {
        return "POJOJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId='" + userId + '\'' +
                ", id=" + id +
                '}';
    }
}
