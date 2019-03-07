package TrainingProgram;

class Course {
  protected int code, lectureHours, practiceHours;
  protected String title;
  protected boolean isSpecial, hasExam, hasCoursePaper;
  protected int[] prerequisities = new int[2];
  protected static final String[] COURSES = { "Логика" , "Теория алгоритмов", "Компьютерное обучение", "Нейронные сети",
      "Защита аппаратных средств", "Криптография", "Информатика", "Математика", "Разработка технологии искусственного интеллекта",
      "Введение в программирование с MATLAB", "Введение в генетику человеческого поведения", "Бактериальные и хронические инфекции",
      "Теория вероятностей", "Дискретная математика", "Основы обработки цифровых видео и изображений" };


  Course(int code_, int lectureHours_, int practiceHours_, String title_, boolean isSpecial_, boolean hasExam_, boolean hasCoursePaper_, int[] prerequisities_) {
    this.code = code_;
    this.lectureHours = lectureHours_;
    this.practiceHours = practiceHours_;
    this.title = title_;
    this.isSpecial = isSpecial_;
    this.hasExam = hasExam_;
    this.hasCoursePaper = hasCoursePaper_;
    this.prerequisities = prerequisities_;
  }

  static void print() {
    System.out.print("------------------------------------------------------------------------------\n"               +
                     "Курс\n1.Логика\n2.Теория алгоритмов\n3.Компьютерное обучение\n4.[Spec]Нейронные сети\n"       +
                     "5.[Spec]Защита аппаратных средств\n6.[Spec]Криптография\n7.Информатика\n8.Математика\n"       +
                     "9.Разработка технологии искусственного интеллекта\n10.Введение в программирование с MATLAB\n" +
                     "11.[Spec]Введение в генетику человеческого поведения\n12.[Spec]Бактериальные и хронические "  +
                     "инфекции\n13.[Spec]Теория вероятностей\n14.Дискретная математика\n15.[Spec]Основы обработки " +
                     "цифровых видео и изображений\n"                                                               +
                     "------------------------------------------------------------------------------\n");
  }
}