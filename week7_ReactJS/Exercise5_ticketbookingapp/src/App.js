import React, { useState } from 'react';

// 1️⃣ LoginButton & LogoutButton
function LoginButton({ onClick }) {
  return <button onClick={onClick}>Login</button>;
}

function LogoutButton({ onClick }) {
  return <button onClick={onClick}>Logout</button>;
}

// 2️⃣ FlightDetails: always visible
function FlightDetails() {
  return (
    <section style={{ border: '1px solid #ccc', padding: 16, marginBottom: 16 }}>
      <h2>Available Flights</h2>
      <ul>
        <li>NYC → LON  (₹50,000)</li>
        <li>DEL → MUM  (₹8,000)</li>
        <li>BLR → CHN  (₹5,500)</li>
      </ul>
    </section>
  );
}

// 3️⃣ BookingPanel: only for logged‐in users
function BookingPanel() {
  return (
    <section style={{ border: '1px solid green', padding: 16 }}>
      <h2>Book Your Ticket</h2>
      <p>Select your flight and enter passenger details…</p>
      {/* form or UI would go here */}
    </section>
  );
}

// 4️⃣ GuestPage & UserPage
function GuestPage({ onLogin }) {
  return (
    <div>
      <p>Please sign up or log in to book tickets.</p>
      <LoginButton onClick={onLogin} />
    </div>
  );
}

function UserPage({ onLogout }) {
  return (
    <div>
      <p>Welcome back! You can now book your tickets.</p>
      <LogoutButton onClick={onLogout} />
    </div>
  );
}

function App() {
  // ✅ isLoggedIn state
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // ✅ Handlers
  const handleLogin  = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  // 1️⃣ Element variable for the header/controls
  let controlPanel;
  if (isLoggedIn) {
    controlPanel = <UserPage onLogout={handleLogout} />;
  } else {
    controlPanel = <GuestPage onLogin={handleLogin} />;
  }

  return (
    <div style={{ maxWidth: 600, margin: '40px auto', fontFamily: 'sans-serif' }}>
      <h1>✈️ Ticket Booking App</h1>

      {/* Always show flights */}
      <FlightDetails />

      {/* Show login/signup or welcome+logout */}
      {controlPanel}

      {/* Only render BookingPanel if logged in */}
      {isLoggedIn && <BookingPanel />}
    </div>
  );
}

export default App;