let coll = document.body.children;
var arr = Array.prototype.slice.call(coll,0)
var ht = 0
console.log(coll);
for(var i = 0; i < coll.length; i++){
    if(coll[i].className !== "footer"){
        console.log(coll[i]);
        ht += coll[i].scrollHeight
    }
}
console.log(ht);
let footer = document.getElementsByClassName("footer")
footer[0].style.height = "calc(100% - " + ht + "px)"

