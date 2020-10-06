import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Navbar from "./Navar";
import Quest from "./pages/Quest";
import PuzzlePage from './PuzzlePage/PuzzlePage';

function App() {
  return (
    <div className='container'>
      <Navbar/>
      <Quest/>
      <PuzzlePage/>
    </div>
  );
}

export default App;
