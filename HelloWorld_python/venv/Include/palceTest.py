
score = 100
print("my english is %d" %score)

mathScore = 200

print("my english is %d, ma math is %d" %(score,mathScore))


list=[1,2,3,4,56,7,8,99,3];

for l in list:
    if l == 56:
        continue;
    print(l, end=",");



class people:
    def __init__(man,name,age,sex,year):
        man.name=name
        man.age=age
        man.sex=sex
        man.year='2018'

    def read_odomter(man):
        print("this man's name is "+man.name + " And age is " +man.age+" And Sex is "+man.sex+" And Year is " + man.year);

    def get_description(man):
        log_Name = str(man.name ) + ' ' + str(man.age) + ' ';
        return log_Name.title();


new_People = people('alice','22','男','2017')
new_People.read_odomter();
print(new_People.get_description())