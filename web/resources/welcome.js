$(function() {

   new Vue({
       el: '#welcome-app',
       components: {
       },
       data() {
           return {
               recommendations: [],
               rootUrl: GLOBALS.root_url,
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