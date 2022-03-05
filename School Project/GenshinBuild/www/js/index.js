var card = document.querySelector(".DPS").children;
var card2 = document.querySelector(".SOUTIENT").children;
var card3 = document.querySelector(".HEALEUR").children;
var radio = document.querySelectorAll('input[name="options"]'); 
var search = document.querySelector(".search")
var label = document.querySelectorAll(".lB");
var act = document.querySelector(".ACTUALITE").children;
var img = document.querySelector("#YAEEEEEE");

function toggleUl(){
    var curentCard = event.currentTarget;
    for(i = 0; i<card.length;i++){
        if(curentCard == card[i]){
            var u = curentCard.querySelector("ul");
            u.classList.toggle("cache");
        }
    }
}

function toggleUl2(){
    var curentCard = event.currentTarget;
    for(i = 0; i<card2.length;i++){
        if(curentCard == card2[i]){
            var u = curentCard.querySelector("ul");
            u.classList.toggle("cache");
        }
    }
}

function toggleUl3(){
    var curentCard = event.currentTarget;
    for(i = 0; i<card3.length;i++){
        if(curentCard == card3[i]){
            var u = curentCard.querySelector("ul");
            u.classList.toggle("cache");
        }
    }
}

for(i = 0; i<card.length;i++){
    card[i].addEventListener("click", function(){
        toggleUl();
    })
}

for(i = 0; i<card2.length;i++){
    card2[i].addEventListener("click", function(){
        toggleUl2();
    })
}

for(i = 0; i<card3.length;i++){
    card3[i].addEventListener("click", function(){
        toggleUl3();
    })
}

function check(){
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
    if(document.querySelector("#Tous").checked){
        for(i = 0; i<card.length;i++){
           if(card[i].classList.contains("cache")){
               card[i].classList.toggle("cache");
           }
        }
        for(i = 0; i<card2.length;i++){
            if(card2[i].classList.contains("cache")){
                card2[i].classList.toggle("cache");
            }
         }
         for(i = 0; i<card3.length;i++){
            if(card3[i].classList.contains("cache")){
                card3[i].classList.toggle("cache");
            }
         }
        for(i=0; i<act.length; i++){
            if(!act[i].classList.contains("cache")){
                act[i].classList.toggle("cache");
            }
        }
    }
    if(document.querySelector("#DPS").checked){
        for(i = 0; i<card2.length;i++){
            if(!card2[i].classList.contains("cache")){
                card2[i].classList.toggle("cache");
            }
         }
        for(i = 0; i<card.length;i++){
            if(card[i].classList.contains("cache")){
                card[i].classList.toggle("cache");
            }
        }
        for(i = 0; i<card3.length;i++){
            if(!card3[i].classList.contains("cache")){
                card3[i].classList.toggle("cache");
            }
        }
        for(i=0; i<act.length; i++){
            if(!act[i].classList.contains("cache")){
                act[i].classList.toggle("cache");
            }
        }
    }
    if(document.querySelector("#SOUTIENT").checked){
        for(i = 0; i<card.length;i++){
            if(!card[i].classList.contains("cache")){
                card[i].classList.toggle("cache");
            }
         }
        for(i = 0; i<card2.length;i++){
            if(card2[i].classList.contains("cache")){
                card2[i].classList.toggle("cache");
            }
        }
        for(i = 0; i<card3.length;i++){
            if(!card3[i].classList.contains("cache")){
                card3[i].classList.toggle("cache");
            }
        }
        for(i=0; i<act.length; i++){
            if(!act[i].classList.contains("cache")){
                act[i].classList.toggle("cache");
            }
        }
    }

    if(document.querySelector("#HEALEUR").checked){
        for(i = 0; i<card.length;i++){
            if(!card[i].classList.contains("cache")){
                card[i].classList.toggle("cache");
            }
         }
        for(i = 0; i<card2.length;i++){
            if(!card2[i].classList.contains("cache")){
                card2[i].classList.toggle("cache");
            }
        }
        for(i = 0; i<card3.length;i++){
            if(card3[i].classList.contains("cache")){
                card3[i].classList.toggle("cache");
            }
        }
        for(i=0; i<act.length; i++){
            if(!act[i].classList.contains("cache")){
                act[i].classList.toggle("cache");
            }
        }
    }
    if(document.querySelector("#ACTUALITE").checked){
        for(i = 0; i<card.length;i++){
            if(!card[i].classList.contains("cache")){
                card[i].classList.toggle("cache");
            }
         }
        for(i = 0; i<card2.length;i++){
            if(!card2[i].classList.contains("cache")){
                card2[i].classList.toggle("cache");
            }
        }
        for(i = 0; i<card3.length;i++){
            if(!card3[i].classList.contains("cache")){
                card3[i].classList.toggle("cache");
            }
        }
        for(i=0; i<act.length; i++){
            if(act[i].classList.contains("cache")){
                act[i].classList.toggle("cache");
            }
        }
    }
}

function resultSearch(e){
        for(i =0;i<card.length;i++){
            var nom = card[i].querySelector("h5").innerText;
            if(search.value != nom && !card[i].classList.contains("cache")){
                card[i].classList.toggle("cache")
            }
            if((nom.toLowerCase()).includes(search.value.toLowerCase()) && card[i].classList.contains("cache")){
                card[i].classList.toggle("cache")
            }
        }
        for(i=0;i<card2.length;i++){
            var nom1 = card2[i].querySelector("h5").innerText;
            if(search.value != nom1 && !card2[i].classList.contains("cache")){
                card2[i].classList.toggle("cache")
            }
            if((nom1.toLowerCase()).includes(search.value.toLowerCase()) && card2[i].classList.contains("cache")){
                card2[i].classList.toggle("cache")
            }
        }
        for(i=0;i<card3.length;i++){
            var nom2 = card3[i].querySelector("h5").innerText;
            if(search.value != nom2 && !card3[i].classList.contains("cache")){
                card3[i].classList.toggle("cache")
            }
            if((nom2.toLowerCase()).includes(search.value.toLowerCase()) && card3[i].classList.contains("cache")){
                card3[i].classList.toggle("cache")
            }
        }
}

function changementImage(){
    for(i =0; i<card.length; i++){
        var cardUl = card[i].querySelector("ul");
        var images = cardUl.querySelectorAll(".a");
        if(images.length == 2){
            for(j = 0;j < images.length; j++){
                images[j].classList.toggle("cache");
            }
        }
    }
    for(i =0; i<card2.length; i++){
        var cardUl = card2[i].querySelector("ul");
        var images = cardUl.querySelectorAll(".a");
        if(images.length == 2){
            for(j = 0;j < images.length; j++){
                images[j].classList.toggle("cache");
            }
        }
    }
    for(i =0; i<card3.length; i++){
        var cardUl = card3[i].querySelector("ul");
        var images = cardUl.querySelectorAll(".a");
        if(images.length == 2){
            for(j = 0;j < images.length; j++){
                images[j].classList.toggle("cache");
            }
        }
    }
}

for(i = 0; i<radio.length;i++){
    radio[i].addEventListener("click", function(){
        check();
    })
}

search.addEventListener('keyup',resultSearch)

window.onload =  function(){
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
    if(window.innerWidth < 769){
        search.setAttribute("size","6");
        for(i = 0; i<label.length; i++){
            label[i].classList.toggle("d-block")
        }
        img.classList.toggle("float-end")
        let y = img.querySelector("#imgYae");
        y.setAttribute("height","36%")
        y.removeAttribute("width")
        y.classList.toggle("img-fluid")
        y.classList.toggle("float-end")
    }
    setInterval(changementImage,3000);
}



window.onresize = function(){
    if(window.innerWidth < 769){
        search.setAttribute("size","6");
        for(i = 0; i<label.length; i++){
            if(!label[i].classList.contains("d-block")){
                label[i].classList.toggle("d-block")
            }
        }
        if(img.classList.contains("float-end")){
            img.classList.toggle("float-end")
            img.classList.toggle("img-fluid")
            img.setAttribute("height","36%")
            img.removeAttribute("width");
            let y = img.querySelector("#imgYae");
            y.classList.toggle("img-fluid")
            y.classList.toggle("float-end")
            y.removeAttribute("width")
        }
    }else{
        search.removeAttribute("size");
        for(i = 0; i<label.length; i++){
            if(label[i].classList.contains("d-block")){
                label[i].classList.toggle("d-block")
            }
        }
        if(!img.classList.contains("float-end")){
            img.classList.toggle("float-end")
            img.removeAttribute("height");
            let y = img.querySelector("#imgYae");
            y.setAttribute("height","32%");
            y.setAttribute("width","32%");
            if(y.classList.contains("img-fluid")){
                y.classList.toggle("img-fluid")
            }
        }
        if(img.classList.contains("img-fluid")){
            img.classList.toggle("img-fluid")
        }
    }
}

