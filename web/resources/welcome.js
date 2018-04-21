$(function() {
   new Vue({
       el: '#welcome-app',
       data() {
           return {
               recommendations: [],
           };
       },
       
       mounted() {
           var self = this;
            $.getJSON({
                url: GLOBALS.root_url + 'recommendations',
            }).done(function(resp) {
                self.recommendations = resp;
            });
       },
   }); 
});