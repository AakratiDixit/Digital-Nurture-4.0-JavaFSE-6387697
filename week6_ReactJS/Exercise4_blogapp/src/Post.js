import React from 'react';

function Post(props) {
  return (
    <div style={{ marginBottom: '20px' }}>
      <h3>{props.title}</h3>
      <p>{props.body}</p>
    </div>
  );
}

export default Post;
