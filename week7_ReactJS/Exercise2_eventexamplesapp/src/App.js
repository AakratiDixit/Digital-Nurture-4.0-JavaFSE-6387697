import React, { Component } from 'react';
import CurrencyConverter from './CurrencyConverter';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App" style={{ padding: 20 }}>
        <h1>React Event Examples</h1>
        {/* 1. Counter with multiple handlers */}
        <Counter />

        <hr />

        {/* 2. Say Welcome */}
        <WelcomeButton />

        <hr/>

        {/* 3. Synthetic onClick */}
        <SyntheticDemo />

        <hr/>

        {/* 4. Currency Converter */}
        <CurrencyConverter />
      </div>
    );
  }
}

export default App;

// 1. Counter component
class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    // bind handlers if not arrow
    this.increment = this.increment.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.decrement = this.decrement.bind(this);
  }

  // a) increments state.count
  increment() {
    this.setState(({ count }) => ({ count: count + 1 }));
  }

  // b) alerts a static message
  sayHello() {
    alert('Hello! You clicked Increment.');
  }

  // single method can call both
  handleIncrease = () => {
    this.increment();
    this.sayHello();
  };

  // decrease
  decrement() {
    this.setState(({ count }) => ({ count: count - 1 }));
  }

  render() {
    return (
      <div>
        <h2>Counter: {this.state.count}</h2>
        {/* “Increase” invokes multiple handlers */}
        <button onClick={this.handleIncrease}>Increase</button>{' '}
        {/* “Decrease” */}
        <button onClick={this.decrement}>Decrease</button>
      </div>
    );
  }
}

// 2. WelcomeButton
function WelcomeButton() {
  // handler factory: takes arg “welcome”
  const sayWelcome = (msg) => {
    alert(msg + ', friend!');
  };

  return (
    <div style={{ marginTop: 20 }}>
      <button onClick={() => sayWelcome('Welcome')}>Say Welcome</button>
    </div>
  );
}

// 3. SyntheticDemo
function SyntheticDemo() {
  const handlePress = (e) => {
    // e is a React SyntheticEvent
    console.log(e.type, e); 
    alert('I was clicked!');
  };

  return (
    <div style={{ marginTop: 20 }}>
      <button onClick={handlePress}>Click me (Synthetic Event)</button>
    </div>
  );
}


