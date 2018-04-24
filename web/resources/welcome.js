$(function() {

   new Vue({
       el: '#welcome-app',
       components: {
       },
       data() {
           return {
               recommendations: [],
               pinnedTracks: [],
               selectedTrack: null,
               modalBoards: [],
               userBoards: [],
               rootUrl: GLOBALS.root_url,
           };
       },
       
       methods: {
         showBoardsModal(track) {
             this.selectedTrack = track;
             this.modalBoards = [];
             for(var i = 0; i < this.userBoards.length; i++) {
                 this.modalBoards.push({
                     pinned: this.hasBoardTrack(this.userBoards[i], this.selectedTrack),
                     board: this.userBoards[i],
                 });
             }
             $('#boardsModal').modal({});
         },
         savePins() {
             var self = this;
             
             var ajaxCalls = [];
           for(var i = 0; i < this.modalBoards.length; i++) {
               var action = 'unpin';
               if(this.modalBoards[i].pinned) {
                   action = 'pin';
               }

                ajaxCalls.push($.getJSON({
                    url: GLOBALS.root_url + 'boards?action=' + action,
                    method: 'post',
                    data: {
                        track: self.selectedTrack.id,
                        board: self.modalBoards[i].board.id,
                    },
                }));
           }
           
           $('#boardsModal').modal('hide');
           
           $.when.apply(this, ajaxCalls).done(function() {
               self.fetchData();
           });
         },
         hasBoardTrack(board, track) {
             if(track === null) {
                 return false;
             }
             
           for(var i = 0; i < board.tracks.length; i++) {
               if(board.tracks[i].id === track.id) {
                   return true;
               }
           }  
           
           return false;
         },
         
         fetchData() {
           var self = this;
            $.getJSON({
                url: GLOBALS.root_url + 'pins',
                method: 'get',
            }).done(function(resp) {
                self.pinnedTracks = resp.tracks;
            });
            
            $.getJSON({
                url: GLOBALS.root_url + 'boards?action=mine',
                method: 'get',
            }).done(function(resp) {
                self.userBoards = resp;
            });
         }
       },
       
       mounted() {
           this.fetchData();
       },
   }); 
});