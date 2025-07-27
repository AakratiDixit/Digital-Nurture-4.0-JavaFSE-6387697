import React, { useState } from 'react';

// Sample data
const books = [
  { id: 101, name: "Master React", price: 670 },
  { id: 102, name: "Deep Dive into Angular 11", price: 800 },
  { id: 103, name: "Mongo Essentials", price: 450 },
];
const blogs = [
  { id: 'b1', title: "Understanding JSX", excerpt: "JSX lets you write HTML in JS..." },
  { id: 'b2', title: "React Lifecycle", excerpt: "Mounting, updating, unmounting..." },
  { id: 'b3', title: "Hooks Deep Dive", excerpt: "useState, useEffect, and beyond..." },
];
const courses = [
  { id: 'c1', title: "Intro to JavaScript", duration: "4 weeks" },
  { id: 'c2', title: "Advanced CSS", duration: "6 weeks" },
  { id: 'c3', title: "Full‑Stack with Node.js", duration: "8 weeks" },
];

// BookDetails
function BookDetails() {
  return (
    <div>
      <h2>📚 Book Details</h2>
      <ul>
        {books.map(b => (
          <li key={b.id}>{b.name} — ₹{b.price}</li>
        ))}
      </ul>
    </div>
  );
}

// BlogDetails
function BlogDetails() {
  return (
    <div>
      <h2>📝 Blog Details</h2>
      <ul>
        {blogs.map(b => (
          <li key={b.id}>
            {b.title} — {b.excerpt}
          </li>
        ))}
      </ul>
    </div>
  );
}

// CourseDetails
function CourseDetails() {
  return (
    <div>
      <h2>🎓 Course Details</h2>
      <ul>
        {courses.map(c => (
          <li key={c.id}>{c.title} — {c.duration}</li>
        ))}
      </ul>
    </div>
  );
}

function App() {
  const [view, setView] = useState('books'); // 'books' | 'blogs' | 'courses'

  // Decide which component to render
  let elementToRender;
  if (view === 'books') {
    elementToRender = <BookDetails />;
  } else if (view === 'blogs') {
    elementToRender = <BlogDetails />;
  } else {
    elementToRender = <CourseDetails />;
  }

  return (
    <div style={{ padding: 20, fontFamily: 'sans-serif' }}>
      <h1>📖 Blogger App</h1>

      {/* Buttons to switch view */}
      <div style={{ marginBottom: 20 }}>
        <button onClick={() => setView('books')}>Show Books</button>{' '}
        <button onClick={() => setView('blogs')}>Show Blogs</button>{' '}
        <button onClick={() => setView('courses')}>Show Courses</button>
      </div>

      {/* Render selected content */}
      {elementToRender}

      <hr />

      {/* Show current view message */}
      {view === 'books' && <p>You are viewing <strong>Books</strong>.</p>}
      {view === 'blogs' && <p>You are viewing <strong>Blogs</strong>.</p>}
      {view === 'courses' && <p>You are viewing <strong>Courses</strong>.</p>}
    </div>
  );
}

export default App;
