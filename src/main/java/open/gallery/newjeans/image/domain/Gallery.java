package open.gallery.newjeans.image.domain;

public enum Gallery {

  NEWJEANS("NewJeans", ""),
  ;

  private String title;
  private String url;

  Gallery(String title, String url) {
    this.title = title;
    this.url = url;
  }
}