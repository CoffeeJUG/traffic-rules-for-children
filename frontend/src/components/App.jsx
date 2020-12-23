import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Navbar from './Navbar/Navar';
// import Quest from './pages/QuestPage/Quest';
// import PuzzlePage from './PuzzlePage/PuzzlePage';
// import CanvasPage from './pages/Canvas/CanvasPage';
import Map from './pages/Map/Map';

import Cookies from 'js-cookie'

Cookies.set('puzzle-kid-game', 
	{
	"name" : "Irusya",
	"completedLevel" : 5,
	"mistakes" : 3,
	}
);
console.log(Cookies.get('puzzle-kid-game'));

function App() {
  return (
    <div>
      <Navbar />
      <Map />
    </div>
  );
}

export default App;
