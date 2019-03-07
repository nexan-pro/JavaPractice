package NewsDepartment;

class NewsOperator {
  enum Categories { NEWS, WEATHER, SPORT, INCIDENT, HUMOR };
  ServiceSubscriber subscriber;

  NewsOperator(ServiceSubscriber subscriber) {
    this.subscriber = subscriber;
  }

  /**
   * Add news to library
   * @param content - content of news
   * @param category - category of news e.g. Categories (news, weather, sport, incident, humor)
   */
  void addNews(String content, Categories category) {
    if (category.name().equals(subscriber.getCategory()))
      System.out.println("Received new news from " + subscriber.getCategory() + " : " + content);
  }
}
