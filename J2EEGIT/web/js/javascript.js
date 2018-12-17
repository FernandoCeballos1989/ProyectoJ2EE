/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


jQuery('document').ready(function($){
   
   //Se identifican los elementos 
    var menuBtn = $('.menu-icon'), //menu-icon (el icono)
      menu=$('.navigation ul'); //navigation ul (lista de secciones nav)
    
    menuBtn.click(function(){
    
        if(menu.hasClass('show')){
             menu.removeClass('show'); //se elimina la clase class del ul
        }else{
            menu.addClass('show'); //se agrega la clase class del ul
        }
        
        
    });
    
});