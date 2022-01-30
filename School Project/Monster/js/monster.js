'use strict';


var nom;
var life = 10; //valeur arbitraire qui permet d'avoir une valeur de base
var money = 6; //valeur arbitraire qui permet d'avoir une valeur de base 
var awake = true;//Valeur qui met le monstre en réveiller
var run = document.getElementById("b2"); //variable associé au bouton run
var fight = document.getElementById("b3");//variable associé au bouton fight
var work = document.getElementById("b7");//variable associé au bouton work
var sleep = document.getElementById("b4");//variable associé au bouton sleep
var eat = document.getElementById("b5");//variable associé au bouton eat
var show = document.getElementById("b6");//variable associé au bouton show
var newlife = document.getElementById("b1");//variable associé au bouton newlife
var kill = document.getElementById("k");//variable associé au bouton kill
var actionbox = document.getElementById("actionbox");//variable associé a l'action box
var status = document.getElementById("status");//variable aussocié au status du monstre
var mort = false;//variable qui vérifie la mort d'un perso
var monst = document.getElementById("monster");//Variable qui récupère le carrée qui indique la vie et l'argent du monstre
const timer =  7000;//timer qui permet de definir le temps de sommeille du monstre
var evt = [fuir, attaquer, travaille, manger, dormir];//tableau qui contient les fonction 
var etat = document.getElementById("etat");//variable qui change l'image pour afficher une image différente selon l'état du monstre

//fonction qui permet d'initialisé le monstre
function init(n, l, m){
	nom = n;
	life = l;
	money = m;
}

//fonction qui affiche le nom, la vie et l'argent du monstre dans le log 
function showme(){
	log("Nom du monstre : "+nom+" | Vie du monstre : "+life+" | Argent du monstre : "+money);
	//displayStatus(life,money,awake);
}

//fonction qui s'active lors du chargement de la fenêtre qui demande un nom au monstre et l'initialise, met a jour le displaystatus et attribut les boutons
function go(){ 
	let n = window.prompt("Entrez le nom du monstre : ");
	init(n , life , money);
	displayStatus(life,money,awake);
	show.addEventListener("click", showme);
	run.addEventListener("click",fuir);
	fight.addEventListener("click", attaquer);
	work.addEventListener("click", travaille);
	eat.addEventListener("click",manger);
	sleep.addEventListener("click",dormir);
	newlife.addEventListener("click", nouvelleVie);
	kill.addEventListener("click", tuer);
}

//fonction qui affiche les action du monstre dans l'action box
function log(message){
	let premier = actionbox.firstElementChild;
	console.log(premier);
	let p = document.createElement("p");
	let msg = document.createTextNode(message);
	p.appendChild(msg);
	actionbox.insertBefore(p,premier);
}

//Fonction qui met a jour le status du monstre au niveau de la barre d'état mais aussi du carré et crée une bordure en fonction de la quantite d'argent
function displayStatus(life, money, awake){
	let li = document.querySelectorAll("li");
	let n = monst.querySelectorAll("p");
	n[0].textContent = nom;
	li[0].textContent = "Life : "+life;
	li[1].textContent = "Money : "+money;
	if(!awake){
		li[2].textContent = "Sleep";
	}else{
		li[2].textContent = "Awake";
	}

	if(life >=0){
		monst.style.backgroundColor = "red";
		etat.setAttribute("src", "image/ZeroTwoSad.png");
	}
	if(life >=5){
		monst.style.backgroundColor = "orange";
		etat.setAttribute("src", "image/ZeroTwo104.png");
	}
	if(life >=10){
		monst.style.backgroundColor = "blue";
		etat.setAttribute("src", "image/ZeroTwoOmg.png");
	}
	if(life >= 15){
		monst.style.backgroundColor = "green";
		etat.setAttribute("src", "image/ZeroTwoYay.png");
	}
	let taille = 0.8*money;
	monst.style.borderWidth = taille+"px";
	monst.style.borderColor = "gold";
	monst.style.borderStyle = "solid";

}

//fonction qui permet au monstre de fuir (run) et perd un pv lorsque cela arrive
function fuir(){
	if(!mort){
		if(awake && life > 0){
			life -= 1;
			displayStatus(life,money,awake);
			log(nom+" a fuis, il a perdu 1 point de vie");
			document.body.style.backgroundColor = "red";
			if(life <= 0){
				life =0;
				log(nom+ " en est mort...");
				document.body.style.backgroundColor = "darkslateblue";
				mort =true;
			}else{
				window.setTimeout(retablir, 200);
			}
		}else if(!awake){
			log(nom+" dort !");
		}else if(life <= 0){
			log(nom+" est mort !");
		}
	}
}

//attaquer qui permet au monstre d'attaquer mais lui fais perdre 3 pv
function attaquer(){
	if(!mort){
		if(awake && life>=3){
			life -= 3;
			displayStatus(life,money,awake);
			log(nom+" s'est battue !  Il a perdu 3 point de vie");
			document.body.style.backgroundColor = "red";
			if(life <= 0){
				life =0;
				log(nom+ " en est mort...");
				document.body.style.backgroundColor = "darkslateblue";
				mort =true;
			}else{
				window.setTimeout(retablir, 200);
			}
		}else if(!awake){
			log(nom+" dort !");
		}else if(life<3){
			log(nom+" n'as pas assez de point de vie pour se battre !");
		}
	}
}

//fonction qui permet au monstre de travaillé , ce faisant il ramène 2 d'argent mais perd 1pv;
function travaille(){
	if(!mort){
		if(awake && life>=1){
			life-=1;
			money = Number(money)+2;
			displayStatus(life,money,awake);
			log(nom+" est revenue du travail !  Il s'est un peu épuisé mais a ramener 2 d'argent !");
			document.body.style.backgroundColor = "red";
			if(life <= 0){
				life =0;
				log(nom+ " en est mort...");
				document.body.style.backgroundColor = "darkslateblue";
				mort = true;
			}else{
				window.setTimeout(retablir, 200);
			}
		}else if(!awake){
			log(nom+" dort !");
		}else if(life<1){
			log(nom+" n'as pas assez de point de vie pour travailler !");
		}
	}
}

//fonction qui permet au monstre de manger, il perdra 3 d'argent mais gagnera 2 pv
function manger(){
	if(!mort){
		if(awake && Number(money)>=3){
			life = Number(life)+2;
			money = Number(money)-3;
			displayStatus(life,money,awake);
			log(nom+" a manger ! ");
			document.body.style.backgroundColor = "green";
			window.setTimeout(retablir, 200);
		}else if(!awake){
			log(nom+" dort !");
		}else if(Number(money)<3){
			log(nom+" n'as pas assez d'argent pour manger !");
		}
	}
}

//fonction qui permet au monstre de dormir cette action prend 7s mais redonne 1pv au monstre
function dormir(){
	if(awake && !mort){
		log(nom+" s'endort");
		awake = false;
		displayStatus(life,money,awake);
		let time = window.setTimeout(endormie, timer);
		document.body.style.backgroundColor = "dimGrey";
	}
}

//fonction activé après 7s lors de l'activation de dormir, qui permet de faire récupérer au monstre 1pv
function endormie(){
	log(nom+" est réveiller, il a récuperer un peu de sa fatigue !");
	life = Number(life)+1;
	awake = true;
	displayStatus(life,money,awake);
	document.body.style.backgroundColor = "green";
	window.setTimeout(retablir, 200);

}

//fonction qui execute au hasard une fonction toute les 12seconde
function hasard(){
	let i = Math.floor(Math.random()*4);
	return evt[i]();
}

//fonction qui permet de crée un nouveau monstre uniquement si l'ancien est mort
function nouvelleVie(){
	if(mort){
		let n= prompt("Entrez le nom de votre nouveau monstre : ");
		init(n,10,6);
		displayStatus(life,money,true);
		mort = false;
		document.body.style.backgroundColor = "yellow";
		window.setTimeout(retablir, 200);
		log(nom+" est né");
	}else{
		log("Vous en pouvez avoir qu'un seul monstre a la fois");
	}
}

//fonction qui permet de tuer le monstre actuelle
function tuer(){
	mort = true;
	life = 0;
	money = 0;
	log("vous avez tuer "+nom);
	displayStatus(life, money , false);
	document.body.style.backgroundColor = "darkslateblue";
}

function retablir(){
	document.body.style.backgroundColor = "white";
}

//programme principale
window.addEventListener("load", function(){
	go();
	window.setInterval(hasard,12000);
});