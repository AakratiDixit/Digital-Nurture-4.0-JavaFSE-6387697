import React from 'react';

const IndianPlayers = () => {
  // Destructuring + Odd and Even Team
  const allPlayers = ["Virat", "Rohit", "Gill", "Hardik", "Dhoni", "Pant"];
  const oddPlayers = allPlayers.filter((_, index) => index % 2 === 0);
  const evenPlayers = allPlayers.filter((_, index) => index % 2 !== 0);

  // Merge two arrays
  const T20players = ["Virat", "Rohit", "Bumrah"];
  const RanjiTrophyPlayers = ["Pujara", "Rahane", "Saha"];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers]; // ES6 spread

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>{oddPlayers.map((name, i) => <li key={i}>{name}</li>)}</ul>

      <h2>Even Team Players</h2>
      <ul>{evenPlayers.map((name, i) => <li key={i}>{name}</li>)}</ul>

      <h2>Merged Team (T20 + Ranji)</h2>
      <ul>{mergedPlayers.map((name, i) => <li key={i}>{name}</li>)}</ul>
    </div>
  );
};

export default IndianPlayers;
