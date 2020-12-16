import React from 'react';
import {BrowserRouter, Route} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Navbar from './Navbar/Navar';
import Map from './pages/Map/Map';
import Pazzle from "./pages/Pazzle/Pazzle";
import BestPlayers from "./pages/BestPlayers/BestPlayers";
import Profile from "./pages/Profile/Profile";
import Pazzle1 from "./pages/Pazzle1/Pazzle1";
import MainPage from "./pages/MainPage/MainPage";





function App() {
  return (
      <BrowserRouter>
        <div>
            <Navbar />
            <Route path='/mainPage' component={MainPage}/>
              <Route path='/map' component={Map}/>
              <Route path='/pazzle' component={Pazzle}/>
              <Route path='/pazzle-1' component={Pazzle1}/>
              <Route path='/bestPlayers' component={BestPlayers}/>
              <Route path='/profile' component={Profile}/>
        </div>
      </BrowserRouter>
  );
}

export default App;
