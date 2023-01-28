import openai
# Set the API key
openai.api_key = "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"
# Use the ChatGPT model to generate text
model_engine = "text-davinci-002"
prompt = "Hello, how are you today?"
completion = openai.Completion.create(engine=model_engine, prompt=prompt, max_tokens=1024, n=1,stop=None,temperature=0.7)
message = completion.choices[0].text
print(message)

