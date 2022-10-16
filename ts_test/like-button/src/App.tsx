import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        Tyepscriptはいいぞ
        <LikeButton />

        {/* <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a> */}
      </header>
    </div>
  );
}

function LikeButton() {
  // const count = 999;
  const [count, setCount] = useState(999);
  const handleClick = () => {
    setCount(count + 1);
  };
  // return <span className='likeButton'>♡ {count}</span>;]
  return (
  <span className='likeButton' onClick={handleClick}>♡ {count}</span>
  );
}
export default App;
