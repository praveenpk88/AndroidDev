// ignore_for_file: sort_child_properties_last, prefer_interpolation_to_compose_strings, must_call_super, duplicate_ignore, unused_element

import 'package:fitness/models/category_model.dart';
import 'package:fitness/models/diet_model.dart';
import 'package:fitness/models/popular_model.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class Homepage extends StatefulWidget {
  const Homepage({super.key});

  @override
  State<Homepage> createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {
  List<CategoryModel> categories = [];
  List<DietModel> diets =[];
  List<PopularDietsModel> popularDiets = [];

  void _getCategories() {
    categories = CategoryModel.getCategories();
  }

  void _getDiets(){
    diets = DietModel.getDiets();
  }

  void _getInitialInfo() {
    categories = CategoryModel.getCategories();
    diets = DietModel.getDiets();
    popularDiets = PopularDietsModel.getPopularDiets();
  }

  @override
  void initState(){
    _getCategories();
  }

  @override
  Widget build(BuildContext context) {
    _getInitialInfo();
    return Scaffold(
      appBar: appBar(),
      backgroundColor: Colors.white,
      body: ListView(
          children: [
            _searchField(),
            const SizedBox(height: 40,),
            _categoriesSection(),
            const SizedBox(height: 40,),
            _dietSection(),
            const SizedBox(height: 40,),
            _popularItems(),
            const SizedBox(height: 40,),
          ],
      ),
    );
  }

  Column _popularItems() {
    return Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const Padding(
            padding: EdgeInsets.all(8.0),
            child: Text(
              'Popular',
              style: TextStyle(
                color: Colors.black,
                fontSize: 18,
                fontWeight: FontWeight.w600
              ),
            ),
          ),
          const SizedBox(height: 15,),
          ListView.separated(
            itemCount: popularDiets.length,
            shrinkWrap: true,
            separatorBuilder: (context, index) => const SizedBox(height: 25,),
            padding: const EdgeInsets.only(
              left: 20,
              right: 20
            ),
            itemBuilder: (BuildContext context, int index) 
            { 
                return Container(
                  height: 100,
                  // ignore: sort_child_properties_last
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      SvgPicture.asset(popularDiets[index].iconPath),
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            popularDiets[index].name,
                            style: const TextStyle(
                              fontWeight: FontWeight.w500,
                              color: Colors.black,
                              fontSize: 16
                            ),
                          ),
                          Text(
                            // ignore: prefer_interpolation_to_compose_strings
                            popularDiets[index].level + ' | ' + popularDiets[index].duration + ' | ' + popularDiets[index].calorie,
                            style: const TextStyle(
                              color: Color(0xff7B6F72),
                              fontSize: 13,
                              fontWeight: FontWeight.w400
                            ),
                          ),
                        ],
                      ),
                      GestureDetector(
                        onTap:  (){},
                        child: SvgPicture.asset(
                          'assets/icons/button.svg',
                          width: 30,
                          height: 30,
                        ),
                      ),
                    ],
                  ),
                  decoration: BoxDecoration(
                    color: popularDiets[index].boxIsSelected ?
                     Colors.white : Colors.transparent,
                    borderRadius: BorderRadius.circular(16),
                    boxShadow: popularDiets[index].boxIsSelected ? [
                      BoxShadow(
                        color: const Color(0xff1D1617).withOpacity(0.07),
                        offset: const Offset(0,10),
                        blurRadius: 40,
                        spreadRadius: 0
                      )
                    ] : []
                  ),
                );
            },
          )
            ],
          );
  }

  Column _dietSection() {
    return Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const Padding(
              padding: EdgeInsets.only(left:20.0),
              child: Text(
                'Recommendation\nfor Diet',
                style: TextStyle(
                  color: Colors.black,
                  fontSize: 18,
                  fontWeight: FontWeight.w600
                ),
              ),
            ),
            const SizedBox(height: 15,),
            // ignore: sized_box_for_whitespace
            Container(
              height: 240,
              child: ListView.separated(
                itemBuilder: (context, index) {
                    return Container(
                      width: 210,
                      decoration: BoxDecoration(
                        color: diets[index].boxColor.withOpacity(0.3),
                        borderRadius: BorderRadius.circular(20)
                      ),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                        children: [
                          SvgPicture.asset(diets[index].iconpath),
                          Column(
                            children: 
                            [
                              Text(
                                diets[index].name,
                                style: const TextStyle(
                                  fontWeight: FontWeight.w500,
                                  color: Colors.black,
                                  fontSize: 16
                                ),
                              ),
                              Text(
                            diets[index].level + ' | ' + diets[index].duration + ' | ' + diets[index].calorie,
                            style: const TextStyle(
                              color: Color(0xff7B6F72),
                              fontSize: 13,
                              fontWeight: FontWeight.w400
                            ),
                          ),
                          ],  
                        ),                 
                          Container(
                            height: 45,
                            width: 130,
                            child: Center(
                              child: Text(
                                'View',
                                style: TextStyle(
                                  color: diets[index].viewIsSelected ? Colors.white : const Color(0xffC588F2),
                                  fontWeight: FontWeight.w600,
                                  fontSize: 14
                                ),
                              )
                              ),                                
                            decoration: BoxDecoration(
                              gradient: LinearGradient(
                                colors: [
                                  diets[index].viewIsSelected ? const Color(0xff9DCEFF) : Colors.transparent,
                                  diets[index].viewIsSelected ? const Color(0xff92A3FD) : Colors.transparent,
                                ]
                                ),
                                borderRadius: BorderRadius.circular(50)
                            ),
                          )
                        ],
                      ),
                    );
                },
                separatorBuilder: (context, index) => const SizedBox(width: 25,),
                itemCount: diets.length,
                scrollDirection: Axis.horizontal,
                )
            )
            ],
          );
  }

  Column _categoriesSection() {
    return Column(
            children: 
            [
              const Padding(
                padding: EdgeInsets.only(left:20.0),
                child: Text(
                  'Category',
                  style: TextStyle(
                    color: Colors.black,
                    fontSize: 18,
                    fontWeight: FontWeight.w600
                  ),
                ),
              ),
              const SizedBox(height: 15),
              SizedBox(
                height: 120,
                child: ListView.separated(
                  itemCount: categories.length,
                  scrollDirection: Axis.horizontal,
                  padding: const EdgeInsets.only(
                    left: 20,
                    right: 20
                  ),
                  separatorBuilder: (context, index) => const SizedBox(width: 25,),
                  itemBuilder: (context, index) {
                    return Container(
                      width: 100,
                      decoration: BoxDecoration(
                        color: categories[index].boxColor.withOpacity(0.3),
                        borderRadius: BorderRadius.circular(16)
                      ),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        Container(
                          height: 50,
                          width: 50,
                          decoration: const BoxDecoration(
                            color: Colors.white,
                            shape: BoxShape.circle
                            ),
                            child: Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: SvgPicture.asset(categories[index].iconpath),
                              ),
                        ),
                        Text(
                          categories[index].name,
                          style: const TextStyle(
                            fontWeight: FontWeight.w400,
                            color: Colors.black,
                            fontSize: 18
                          ),
                        )
                      ],
                    ),
                    );
                  },
                ),
              )
            ],
          );
  }

  Container _searchField() {
    return Container(
            margin: const EdgeInsets.only(top: 40,left: 20, right: 20),
            decoration: BoxDecoration(
              boxShadow: [
                BoxShadow(
                  color: const Color(0xff1D1617).withOpacity(0.11),
                  blurRadius: 40,
                  spreadRadius: 0.0
                )
              ]
            ),
            child: TextField(
              decoration: InputDecoration(
                filled: true,
                contentPadding: const EdgeInsets.all(15),
                fillColor: Colors.white,
                hintText: 'Search Pancake',
                hintStyle: const TextStyle(
                  color: Color(0xffDDDADA),
                  fontSize: 14
                ),
                prefixIcon: Padding(
                  padding: const EdgeInsets.all(12),
                  child: SvgPicture.asset('assets/icons/Search.svg'),
                  ),
                suffixIcon: SizedBox(
                  width: 100,
                  child: IntrinsicHeight(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        const VerticalDivider(
                          color: Colors.black,
                          indent: 10,
                          endIndent: 10,
                          thickness: 0.1,
                        ),
                        Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: SvgPicture.asset('assets/icons/Filter.svg'),
                        ),
                      ],
                    ),
                  ),
                ),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(15),
                  borderSide: BorderSide.none
                )
              ),
            ),
          );
  }

  AppBar appBar() {
    return AppBar(
      title: const Text(
        'Breakfast',
        style: TextStyle(
          color: Colors.black,
          fontSize: 18,
          fontWeight: FontWeight.bold
        ),
        ),
        backgroundColor: Colors.white,
      centerTitle: true,
      // elevation: 0,
      leading: GestureDetector(
        onTap: () {
          
        },
        child: Container(
          margin: const EdgeInsets.all(10),
          alignment: Alignment.center,
          child: SvgPicture.asset(
            'assets/icons/Arrow - Left 2.svg',
            height: 20,
            width: 20,
          ),
          decoration: BoxDecoration(
            color: const Color(0xffF7F8F8),
            borderRadius: BorderRadius.circular(10)
          ),
        ),
      ),
      actions: [
        GestureDetector(
          onTap: (){

          }, 
          child: Container(
          margin: const EdgeInsets.all(10),
          alignment: Alignment.center,
          width: 37,
          child: SvgPicture.asset(
            'assets/icons/dots.svg',
            height: 5,
            width: 5,
          ),
          decoration: BoxDecoration(
            color: const Color(0xffF7F8F8),
            borderRadius: BorderRadius.circular(10)
          ),
        ),
      ),
      ],
    );
  }
}