import logo from './logo.svg';
import './App.css';
import Landing from './Landing';
import Login from './components/Login';
import Register from './components/Register';
import { Button, Modal, Form } from 'react-bootstrap';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Landing></Landing>
      </header>
    </div>
  );
}

export default App;
