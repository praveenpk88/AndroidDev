import 'dart:ui';

class DietModel{
  String name;
  String iconpath;
  String level;
  String duration;
  String calorie;
  Color boxColor;
  bool viewIsSelected;

  DietModel({
      required this.name,
      required this.iconpath,
      required this.level,
      required this.duration,
      required this.calorie,
      required this.viewIsSelected, 
      required this.boxColor
  });

  static List < DietModel > getDiets(){
    List < DietModel > diets = [];

    diets.add(
      DietModel(name: 'Honey Pancake', iconpath: 'assets/icons/honey-pancakes.svg', level: 'Easy', duration: '30mins', calorie: '180kcal', viewIsSelected: true, boxColor: const Color(0xff9DCEFF))
    );

    diets.add(
      DietModel(name: 'Canai Bread', iconpath: 'assets/icons/canai-bread.svg', level: 'Easy', duration: '20mins', calorie: '230kcal', viewIsSelected: false, boxColor: const Color(0xffEEA4CE))
    );
    return diets;
  }

}