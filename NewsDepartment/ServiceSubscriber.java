package NewsDepartment;

class ServiceSubscriber {
  private String category;

  String getCategory() { return category; }

  ServiceSubscriber(NewsOperator.Categories category) {
    this.category = category.name();
  }
}
