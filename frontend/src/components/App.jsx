import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Navbar from "./Navar";
import Quest from "./pages/Quest";

function App() {
  return (
    <div className='container'>
      <Navbar/>
      <Quest/>
    </div>
  );
}

export default App;
