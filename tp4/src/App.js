import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Clients from "./components/Clients";
import HomePage from "./components/HomePage";
import Footer from "./components/Footer";
import Documents from "./components/Documents";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";


function App() {
    return (
        <div>
            <div className="App-header">
                <Header title="Bibliotheque"/>
            </div>
            <Router >
                <div className="container">
                    <Switch>
                        <Route exact path="/" component={HomePage}/>
                        <Route exact path="/clients" component={Clients}/>
                        <Route exact path="/documents" component={Documents}/>
                    </Switch>
                </div>
                <Footer/>
            </Router>
        </div>

    );
}

export default App;
