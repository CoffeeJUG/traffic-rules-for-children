import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Navbar from './Navbar/Navar';
// import Quest from './pages/QuestPage/Quest';
// import PuzzlePage from './PuzzlePage/PuzzlePage';
// import CanvasPage from './pages/Canvas/CanvasPage';
import Map from './pages/Map/Map';

function App() {
  return (
    <div>
      <Navbar />
      <Map />
    </div>
  );
}

export default App;
