
// var GamePiece;

// var Marker;
//
// var Background;
//
// document.addEventListener("DOMContentLoaded", function(event) {
//
//
//     function startGame() {
//         Background = new component(window.innerWidth, window.innerHeight, "/pictures/images-for-canvas/map/map.jpg", 0, 0, "image");
//
//         Marker = new component(125, 200, "/pictures/images-for-canvas/marker/marker.svg", 780, 350, "image");
//
//         // GamePiece = new component(10, 20, "images/cursor/cursor_default.jpg", 0,0, "image");
//         GameArea.start();
//     }
//     startGame();
// })
//
//
//
// var GameArea = {
//     canvas : document.createElement("canvas"),
//     start : function() {
//         this.canvas.width = window.innerWidth;
//         this.canvas.height = window.innerHeight;
//         // this.canvas.style.cursor = "none";
//         this.canvas.style.display = "block";
//         this.context = this.canvas.getContext("2d");
//         // this.context.globalCompositeOperation = "destination-over";
//         document.body.appendChild(this.canvas, document.body.childNodes[0]);
//         this.interval = setInterval(updateGameArea, 100);
//
//         window.addEventListener('mousedown', function (e) {
//             GameArea.x = e.pageX;
//             GameArea.y = e.pageY;
//         })
//         window.addEventListener('mouseup', function (e) {
//             GameArea.x = false;
//             GameArea.y = false;
//         })
//         window.addEventListener('touchstart', function (e) {
//             GameArea.x = e.pageX;
//             GameArea.y = e.pageY;
//         })
//         window.addEventListener('touchend', function (e) {
//             GameArea.x = false;
//             GameArea.y = false;
//         })
//
//
//     },
//     clear : function(){
//         this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
//     }
// }
//
// function component(width, height, color, x, y, type) {
//     this.type = type;
//     if (type === "image") {
//         this.image = new Image();
//         this.image.src = color;
//
//     }
//     this.width = width;
//     this.height = height;
//     this.speedX = 0;
//     this.speedY = 0;
//     this.x = x;
//     this.y = y;
//     this.update = function() {
//         let ctx = GameArea.context;
//         if (type === "image") {
//
//             ctx.drawImage(this.image,
//                 this.x,
//                 this.y,
//                 this.width, this.height);
//
//         } else {
//             ctx.fillStyle = color;
//             ctx.fillRect(this.x, this.y, this.width, this.height);
//         }
//     }
//     this.clicked = function(){
//         var myleft = this.x;
//         var myright = this.x + (this.width);
//         var mytop = this.y;
//         var mybottom = this.y + (this.height);
//         var clicked = true;
//         if ((mybottom < GameArea.y) || (mytop > GameArea.y) || (myright < GameArea.x) || (myleft > GameArea.x)) {
//             clicked = false;
//         }
//         return clicked;
//     };
//
// }
// function updateGameArea() {
//     GameArea.clear();
//     if (GameArea.x && GameArea.y) {
//         if(Marker.clicked()){
//             console.log(2);
//             alert('clicked');
//             GameArea.x = false;
//             GameArea.y = false;
//         }
//     }
//     Background.update();
//     Marker.update();
//
//     // GamePiece.update();
// }
// startGame();

// fullscreen
/**
 * Element.requestFullScreen() polyfill
 * @author Chris Ferdinandi
 * @license MIT
 */
if (!Element.prototype.requestFullscreen) {
    Element.prototype.requestFullscreen = Element.prototype.mozRequestFullscreen || Element.prototype.webkitRequestFullscreen || Element.prototype.msRequestFullscreen;
}

/**
 * document.exitFullScreen() polyfill
 * @author Chris Ferdinandi
 * @license MIT
 */
if (!document.exitFullscreen) {
    document.exitFullscreen = document.mozExitFullscreen || document.webkitExitFullscreen || document.msExitFullscreen;
}

/**
 * document.fullscreenElement polyfill
 * Adapted from https://shaka-player-demo.appspot.com/docs/api/lib_polyfill_fullscreen.js.html
 * @author Chris Ferdinandi
 * @license MIT
 */
if (!document.fullscreenElement) {

    Object.defineProperty(document, 'fullscreenElement', {
        get: function() {
            return document.mozFullScreenElement || document.msFullscreenElement || document.webkitFullscreenElement;
        }
    });

    Object.defineProperty(document, 'fullscreenEnabled', {
        get: function() {
            return document.mozFullScreenEnabled || document.msFullscreenEnabled || document.webkitFullscreenEnabled;
        }
    });
}

document.addEventListener('click', function (event) {

    // Ignore clicks that weren't on the toggle button
    if (!event.target.hasAttribute('data-toggle-fullscreen')) return;

    // If there's an element in fullscreen, exit
    // Otherwise, enter it
    if (document.fullscreenElement) {
        document.exitFullscreen();
    } else {
        document.documentElement.requestFullscreen();
    }

}, false);