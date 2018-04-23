$(function() {

   new Vue({
       el: '#track-app',
       components: {
       },
       data() {
           return {
               track: {user: {}},
               boards: [],
               boardName: '',
           };
       },
       
       mounted() {
           this.track = window.track;
           this.boards = window.userBoards;
       },
       
       methods: {
           addBoard() {
                var self = this;
                $.getJSON({
                    url: GLOBALS.root_url + 'boards?action=create',
                    method: 'post',
                    data: {
                        title: self.boardName,
                        isPrivate: false,
                    }
                }).done(function(resp) {
                    self.boards.push(resp);
                });
           },
           pin(board, index) {             
                var self = this;
                
                var action = 'pin';
                if(self.hasPinned(board, self.track)) {
                    action = 'unpin';
                }
                
                $.getJSON({
                    url: GLOBALS.root_url + 'boards?action=' + action,
                    method: 'post',
                    data: {
                        board: board.id,
                        track: self.track.id,
                    }
                }).done(function(resp) {
                    self.$set(self.boards, index, resp);
                });
           },
           hasPinned(board, track) {
               for(var i = 0; i < board.tracks.length; i++) {
                   if(board.tracks[i].id === track.id) {
                       return true;
                   }
               }
               
               return false;
           }
       }
   }); 
});