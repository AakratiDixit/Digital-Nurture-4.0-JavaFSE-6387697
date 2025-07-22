import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div className="App">
      <h1>My Academy Dashboard</h1>
      <CohortDetails 
        name="React Bootcamp" 
        status="ongoing" 
        mentor="Keshav Kumar" 
      />
      <CohortDetails 
        name="Python for Beginners" 
        status="completed" 
        mentor="Rahul Sharma" 
      />
    </div>
  );
}

export default App;
