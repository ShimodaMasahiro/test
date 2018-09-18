document.write("問1");
document.write("<br>");

function totalArea(radius,Pi=3.14){
    return(radius*radius*Pi);
}

document.write(totalArea(5));
document.write("<br>");
document.write(totalArea(7));
document.write("<br>");
document.write(totalArea(10));

document.write("<br>");
document.write("<br>");


document.write("問2");
document.write("<br>");

function totalPrice(adult,child){
    return(adult*500+child*200);
}
document.write("Aグループの合計金額は"+totalPrice(2,4)+"円です");
document.write("<br>");
document.write("Bグループの合計金額は"+totalPrice(1,5)+"円です");
document.write("<br>");
document.write("Cグループの合計金額は"+totalPrice(3,7)+"円です");
document.write("<br>");