document.write("問1")
document.write("<br>")
for(i=1;i<=5;i++){
    document.write("★");
}
document.write("<br>")


document.write("問2")
document.write("<br>")
for(a=1;a<=2;a++){
    for(i=1;i<=3;i++){
        document.write("★");
    }
    document.write("<br>");
}
document.write("<br>")


document.write("問3")
document.write("<br>")
for(i=1;i<=2;i++){
    for(a=1;a<=5;a++){
        document.write("☆");
    }
    document.write("<br>");
}
document.write("<br>")


document.write("問4")
document.write("<br>")
for(i=1;i<=5;i++){
    for(a=1;a<=5;a++){
        document.write("★");
    }
    document.write("<br>");
}
document.write("<br>")


document.write("問5")
document.write("<br>")
var i=1;
while(i<5){
    document.write("★★★"+"<br>");
    i++;
}
document.write("<br>")


document.write("問6")
document.write("<br>")
var i=1;
while(i<=3){
    document.write("★☆★"+"<br>");
    i++;
}
document.write("<br>")


document.write("問7")
document.write("<br>")
var i=1;
while(i<=4){
    document.write("★☆★☆★"+"<br>");
    i++;
}
document.write("<br>")

document.write("問8")
document.write("<br>")

for(i=1;i<=5;i++){
    for(a=1;a<=i;a++){
        document.write("★");
        }
    document.write("<br>");
}