import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Navbar from './Navbar/Navar';
import Quest from './pages/QuestPage/Quest';
import PuzzlePage from './PuzzlePage/PuzzlePage';

function App() {
  return (
    <div>
      <Navbar />
      <Quest />
      <PuzzlePage />
    </div>
  );
}

export default App;
