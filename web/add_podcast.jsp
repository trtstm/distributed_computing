<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.16/vue.js"></script>
    </head>
    
    <body>
        <form method="post">

        </form>
        
        <div id="app">
            <input value="" placeholder="client id" id="client_id" v-model="clientId" />
            <input value="" placeholder="podcast name" id="podcast_name" v-model="query" />
            <button @click="search" type="button" id="search">Search</button>
            
            <ul>
                <li v-for="user in users" @click="addPodcast(user)">{{user.username}}</li>
            </ul>
        </div>
        
        
        <script>
            
            new Vue({
                el: '#app',
                data() {
                    return {
                      users: [],
                      clientId: '',
                      query: '',
                    };
                },
                
                mounted() {
                },
                
                methods: {
                    search() {
                        var self = this;

                       $.getJSON({
                           url: "/pinterest/proxy",
                           data: {
                               url: "http://api.soundcloud.com/users?q=" + self.query + "&client_id="+self.clientId
                           },
                       }).done(function(resp) {
                           self.users = resp;
                       });
                    },
                    addPodcast(user) {
                        var self = this;
                        var podcast = {
                            title: user.username,
                            description: user.description,
                            external_id: user.id,
                            artwork_url: user.avatar_url,
                            tracks: [],
                        };
                        
                       $.getJSON({
                           url: "/pinterest/proxy",
                           data: {
                               url: "http://api.soundcloud.com/users/" + user.id.toString() + "/tracks?client_id="+self.clientId
                           },
                       }).done(function(resp) {
                           for(var i = 0; i < resp.length; i++) {
                               podcast.tracks.push({
                                   title: resp[i].title,
                                   artwork_url: resp[i].artwork_url,
                                   duration: resp[i].duration,
                                   stream_url: resp[i].stream_url,
                                   description: resp[i].description,
                                   external_id: resp[i].id,
                               });
                           }
                           
                               self.savePodcast(podcast);
                       });
                    },
                    savePodcast(podcast) {
                       $.ajax({
                           url: "",
                           method: 'post',
                           data: podcast
                       }).done(function(resp) {
                           
                       });
                    }
                }
            });
            
           
        </script>
    </body>
</html>