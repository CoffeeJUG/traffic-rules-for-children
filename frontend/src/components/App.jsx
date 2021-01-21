import React from 'react';
import {BrowserRouter, Route} from "react-router-dom";
import Navbar from './Navbar/Navar';
import Pazzle from "./pages/Pazzle/Pazzle";
import BestPlayers from "./pages/BestPlayers/BestPlayers";
import Profile from "./pages/Profile/Profile";
import MainPage from "./pages/MainPage/MainPage";
import Map from './pages/Map/Map';
import Cookies from 'js-cookie';
const { JSDOM } = require( "jsdom" );
const { window } = new JSDOM( "" );
const $ = require( "jquery" )( window );

import 'bootstrap/dist/css/bootstrap.css';
// cookie set exmpl
Cookies.set('green-light_profile', 
	{
		"name" : "Irusya",
		"completedLevel" : 5,
		"mistakes" : 3,
		"fullscreen" : 1,
		"progress" : 2
	}
);

let game = {
	pazzles: {
		0:{
			questNumber: '1',
			task: {
				type: 'select'
				elements: {
					0: {
						correct: false,
						
					}
				}
			}
			description: 'Обери знак, який дозволяє безпечно перейти дорогу.',
			styles: {
				left: 137,
				top: 364 
			}
			elements: {

			}
		},
		1:{
			questNumber: '2',
			task: 'select',
			description: 'Обери знак, який дозволяє безпечно перейти дорогу2.',
			styles: {
				left: 100,
				top: 670 
			}
		},
	},
	player: {
		progress: '3',
	}
}

function App() {
  return (
      <BrowserRouter>
        <div>
            <Navbar />
            <Route path='/mainPage' component={MainPage}/>
              <Route path='/map' render={(props) => (
              	<Map {...props}
              		pazzles={game.pazzles}
              		progress={game.player.progress}
              	/>
              )}/>
              <Route path='/pazzle' render={(props) => (
			    <Pazzle {...props} 
			    />
			  )}/>
              {/*Will use pazzle as main component for all pazzles*/}
              {/*<Route path='/pazzle-1' component={Pazzle1}/>*/}
              <Route path='/bestPlayers' component={BestPlayers}/>
              <Route path='/profile' component={Profile}/>
        </div>
      </BrowserRouter>
  );
}
export default App;
