$(function() {

   new Vue({
       el: '#welcome-app',
       components: {
       },
       data() {
           return {
               recommendedTracks: [],
               pinnedTracks: [],
               selectedTrack: null,
               modalBoards: [],
               userBoards: [],
               followedBoards: [],
               selectedBoard: null,
               newBoard: {title: '', isPrivate: false},
               rootUrl: GLOBALS.root_url,
           };
       },
       
       methods: {
           addBoard() {
               var self = this;

             if(!self.newBoard.title) {
                 return;
             }  
             
                $.getJSON({
                    url: GLOBALS.root_url + 'boards?action=create',
                    method: 'post',
                    data: {
                        title: self.newBoard.title,
                        isPrivate: self.newBoard.isPrivate,
                    }
                }).done(function(resp) {
                    $.when.apply(this, self.fetchData()).then(function() {
                        self.showBoardsModal(self.selectedTrack);
                    });
                });
                
                self.newBoard.title = '';
                self.newBoard.isPrivate = false;
           },
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
         unfollow() {
             var self = this;
            $.ajax({
                url: GLOBALS.root_url + 'boards?action=unfollow',
                method: 'post',
                data: {
                    board: self.selectedBoard.id,
                },
            }).done(function(resp) {
                self.fetchData();
            });
            
            $('#confirmUnfollow').modal('hide');  
         },
         unfollowBoard(board) {
             this.selectedBoard = board;
           $('#confirmUnfollow').modal();  
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
            return [$.getJSON({
                url: GLOBALS.root_url + 'pins',
                method: 'get',
            }).done(function(resp) {
                self.pinnedTracks = resp.tracks;
            }),
            $.getJSON({
                url: GLOBALS.root_url + 'boards?action=mine',
                method: 'get',
            }).done(function(resp) {
                self.userBoards = resp;
            }),
            
            $.getJSON({
                url: GLOBALS.root_url + 'boards?action=followed',
                method: 'get',
            }).done(function(resp) {
                self.followedBoards = resp;
            }),
            
            $.getJSON({
                url: GLOBALS.root_url + 'recommendations',
                method: 'get',
            }).done(function(resp) {
                self.recommendedTracks = resp;
            }),];
         },
         initSliders: function() {
            $('#mixedSlider').multislider({
                    duration: 750,
                    interval: 3000
            });
            
            $('#recommendedSlider').multislider({
                    duration: 750,
                    interval: 3000
            });
         }
       },
       
       mounted() {
           var self = this;
           $.when.apply(this, this.fetchData()).then(function() {
            self.$nextTick(function() {
                self.initSliders();
            });
           });

           
       },
   }); 
});